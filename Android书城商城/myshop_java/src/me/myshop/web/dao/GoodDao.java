package me.myshop.web.dao;

import java.util.List;

import me.myshop.web.po.Good;

public interface GoodDao {
	// 查询商品
	public List<Good> selectGoodList(Good good);

	public Integer selectGoodListCount(Good good);

	// 上架商品
	public int createGood(Good good);

	// 获取商品并更新
	public Good getGoodById(Integer id);

	public int updateGood(Good good);

	// 删除商品
	public int deleteGood(Integer id);

	// 设置商品
	public int setGood(Integer id);

	// JSON
	public List<Good> selectJSONList(Good good);
}