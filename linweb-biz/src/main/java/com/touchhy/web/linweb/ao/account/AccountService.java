package com.touchhy.web.linweb.ao.account;

import com.touchhy.web.linweb.ao.ServiceException;
import com.touchhy.web.linweb.ao.account.ShiroDbRealm.ShiroUser;
import com.touchhy.web.linweb.common.security.utils.Digests;
import com.touchhy.web.linweb.common.utils.Encodes;
import com.touchhy.web.linweb.dao.SsTaskMapper;
import com.touchhy.web.linweb.dao.SsUserMapper;
import com.touchhy.web.linweb.entity.SsTaskExample;
import com.touchhy.web.linweb.entity.SsUser;
import com.touchhy.web.linweb.entity.SsUserExample;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory
			.getLogger(AccountService.class);

	private SsUserMapper ssUserMapper;
	private SsTaskMapper ssTaskMapper;
	private Calendar dateTimeprovider = Calendar.getInstance();

	public List<SsUser> getAllUser() {
		SsUserExample example = new SsUserExample();
		return (List<SsUser>) ssUserMapper.selectByExample(example);
	}

	public SsUser getUser(Long id) {
		return ssUserMapper.selectByPrimaryKey(id);
	}

	public SsUser findUserByLoginName(String loginName) {
		SsUserExample example = new SsUserExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		List<SsUser> list = ssUserMapper.selectByExample(example);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Transactional(readOnly = false)
	public void registerUser(SsUser user) {
		entryptPassword(user);
		user.setRoles("user");
		user.setRegisterDate(dateTimeprovider.getTime());
		ssUserMapper.insert(user);
	}

	@Transactional(readOnly = false)
	public void updateUser(SsUser user) {
		if (StringUtils.isNotBlank(user.getPlainPassword())) {
			entryptPassword(user);
		}
		ssUserMapper.insert(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		ssUserMapper.deleteByPrimaryKey(id);
		SsTaskExample example = new SsTaskExample();
		example.createCriteria().andUserIdEqualTo(id);
		ssTaskMapper.deleteByExample(example);

	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(SsUser user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(),
				salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	public void setDateTimeProvider(Calendar dateTimeProvider) {
		this.dateTimeprovider = dateTimeProvider;
	}
	@Autowired
	public void setSsUserMapper(SsUserMapper ssUserMapper) {
		this.ssUserMapper = ssUserMapper;
	}
	@Autowired
	public void setSsTaskMapper(SsTaskMapper ssTaskMapper) {
		this.ssTaskMapper = ssTaskMapper;
	}
	
}
