package com.lab.mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lab.model.Tutorial;

public class TutorialMapper implements BaseMapper<Tutorial> {

	@Override
	public int insert(Tutorial entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Tutorial entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Wrapper<Tutorial> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBatchIds(Collection<?> idList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Tutorial entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Tutorial entity, Wrapper<Tutorial> updateWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tutorial selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutorial> selectBatchIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectBatchIds(Collection<? extends Serializable> idList, ResultHandler<Tutorial> resultHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long selectCount(Wrapper<Tutorial> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutorial> selectList(Wrapper<Tutorial> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectList(Wrapper<Tutorial> queryWrapper, ResultHandler<Tutorial> resultHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tutorial> selectList(IPage<Tutorial> page, Wrapper<Tutorial> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectList(IPage<Tutorial> page, Wrapper<Tutorial> queryWrapper,
			ResultHandler<Tutorial> resultHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<Tutorial> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectMaps(Wrapper<Tutorial> queryWrapper, ResultHandler<Map<String, Object>> resultHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> selectMaps(IPage<? extends Map<String, Object>> page,
			Wrapper<Tutorial> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectMaps(IPage<? extends Map<String, Object>> page, Wrapper<Tutorial> queryWrapper,
			ResultHandler<Map<String, Object>> resultHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E> List<E> selectObjs(Wrapper<Tutorial> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> void selectObjs(Wrapper<Tutorial> queryWrapper, ResultHandler<E> resultHandler) {
		// TODO Auto-generated method stub
		
	}

}
