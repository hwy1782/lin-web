package com.touchhy.web.linweb.ao.task;

import com.touchhy.web.linweb.dao.SsTaskMapper;
import com.touchhy.web.linweb.entity.SsTask;
import com.touchhy.web.linweb.entity.SsTaskExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Spring Bean的标识.
@Component
//默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class TaskService {

	private SsTaskMapper taskDao;

	public SsTask getTask(Long id) {
		return taskDao.selectByPrimaryKey(id);
	}

	@Transactional(readOnly = false)
	public void saveTask(SsTask entity) {
		taskDao.insertSelective(entity);
	}

	@Transactional(readOnly = false)
	public void deleteTask(Long id) {
		taskDao.deleteByPrimaryKey(id);
	}

	public List<SsTask> getAllTask() {
		SsTaskExample example = new SsTaskExample();
		return (List<SsTask>) taskDao.selectByExample(example);
	}

	public List<SsTask> getUserTask(Long userId, int pageNumber, int pageSize, String sortType) {
		SsTaskExample example = new SsTaskExample();
		example.createCriteria().andUserIdEqualTo(userId);
		example.setStart((pageNumber-1)*pageSize);
		example.setOffset(pageNumber*pageSize);
		return taskDao.selectByExample(example);
	}


	@Autowired
	public void setTaskDao(SsTaskMapper taskDao) {
		this.taskDao = taskDao;
	}
}
