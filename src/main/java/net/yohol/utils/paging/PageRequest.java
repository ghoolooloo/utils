package net.yohol.utils.paging;

import java.io.Serializable;

/**
 * 分页请求
 * @author MAKS-CHENSJ, MAKS-QZHOU
 *
 */
public class PageRequest implements Serializable {
	private static final long serialVersionUID = -7581491171656947284L;
	
	private final Sort sort;
	private final int pageIndex;
	private final int pageSize;
	
	/**
	 * 创建一个不能指定排序方式的 {@link PageRequest}。第一页的页号是0。
	 * 
	 * @param pageIndex 页号
	 * @param pageSize 每页记录数
	 */
	public PageRequest(int pageIndex, int pageSize){
		this(pageIndex, pageSize, null);
	}
	
	/**
	 * 创建一个可指定排序方式的 {@link PageRequest}。第一页的页号是0。
	 * 
	 * @param pageIndex 页号
	 * @param pageSize 每页记录数
	 * @param sort 排序方式，可以为null
	 */
	public PageRequest(int pageIndex, int pageSize, Sort sort) {
		if (pageIndex < 0) {
			throw new IllegalArgumentException("Page index must not be less than zero!");
		}

		if (pageSize < 1) {
			throw new IllegalArgumentException("Page size must not be less than one!");
		}

		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.sort = sort;
	}

	/**
	 * 获取排序方式。
	 * 
	 * @return
	 */
	public Sort getSort() {
		return sort;
	}

	/**
	 * 获取请求的页号。
	 * 
	 * @return
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 获取页的大小。
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 当前页首行的行号。
	 * 
	 * @return
	 */
	public int getOffset() {
		return pageIndex * pageSize;
	}
}
