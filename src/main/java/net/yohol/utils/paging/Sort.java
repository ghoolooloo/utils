package net.yohol.utils.paging;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 排序方式类
 * @author MAKS-CHENSJ，MAKS-QZHOU
 *
 */
public class Sort implements Serializable {
	private static final long serialVersionUID = 6818159534630380159L;
	
	/** 排序列表 */
	private final List<Order> orders;
	
	/**
	 * 从数组中构建一个排序方式对象。
	 * 
	 * @param orders 不能为null。
	 */
	public Sort(Order... orders){
		this(Arrays.asList(orders));
	}
	
	/**
	 * 从List中构造一个排序方式对象。
	 * 
	 * @param orders 不能为 null。
	 */
	public Sort(List<Order> orders){
		if (null == orders || orders.isEmpty()) {
			throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
		}
		
		this.orders = orders;
	}
	
	/**
	 * 获取排序方式的迭代器。
	 * 
	 * @return
	 */
	public Iterator<Order> iterator() {
		return this.orders.iterator();
	} 
	
	/**
	 * 排序对象
	 * @author MAKS-CHENSJ
	 *
	 */
	public static class Order implements Serializable {
		private static final long serialVersionUID = -4984381666100293920L;
		
		/** 排序枚举：升序、降序 */
		private final Direction direction;
		/** 排序字段名称 */
		private final String property;
		
		/**
		 * 构建一个排序对象。
		 * 
		 * @param direction 排序方向。
		 * @param property 排序属性，不能为null或空串。
		 */
		public Order(Direction direction, String property) {
			if (StringUtils.isEmpty(property)) {
				throw new IllegalArgumentException("Property must not null or empty!");
			}

			this.direction = direction == null ? Direction.NONE : direction;
			this.property = property;
		}
		
		/**
		 * 获取排序方向。
		 * 
		 * @return
		 */
		public Direction getDirection() {
			return direction;
		}

		/**
		 * 获取排序属性。
		 * 
		 * @return
		 */
		public String getProperty() {
			return property;
		}
		
		/**
		 * 是否是升序。
		 * 
		 * @return
		 */
		public boolean isAscending() {
			return this.direction.equals(Direction.ASC);
		}
	}

	/**
	 * 排序方向。
	 * 
	 * @author MAKS-QZHOU
	 *
	 */
	public static enum Direction {
		/**
		 * NONE：不排序。
		 * ASC：升序。
		 * DESC：降序。
		 */
		NONE, ASC, DESC;
	}
}
