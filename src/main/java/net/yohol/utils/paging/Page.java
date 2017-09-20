package net.yohol.utils.paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页类
 * @author MAKS-CHENSJ, MAKS-QZHOU
 *
 * @param <T>
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -2178112579581322345L;
	
	private final PageRequest pageRequest;
	private final List<T> content = new ArrayList<T>();
	private final long totalItems;

	/**
	 * 创建一个{@link Page}。
	 * 
	 * @param content 不能为null。
	 * @param pageRequest 可以为null。
	 * @param totalItems 总记录数。
	 */
	public Page(List<T> content, PageRequest pageRequest, long totalItems){
		if (content == null) {
			throw new IllegalArgumentException("Content must not be null!");
		}
		
		this.content.addAll(content);
		this.pageRequest = pageRequest;
		this.totalItems = !content.isEmpty() && pageRequest != null && pageRequest.getOffset() + pageRequest.getPageSize() > totalItems
				? pageRequest.getOffset() + content.size() : totalItems;
	}
	
	/**
	 * 创建一个{@link Page}。这个页包含了所有记录，即总共只有一页数据。
	 * 
	 * @param content 不能为 null。
	 */
	public Page(List<T> content) {
		this(content, null, null == content ? 0 : content.size());
	}

	/**
	 * 获取当前页号。
	 * 
	 * @return
	 */
	public int getIndex() {
		return pageRequest == null ? 0 : pageRequest.getPageIndex();
	}

	/**
	 * 获取每页大小。
	 * 
	 * @return
	 */
	public int getSize() {
		return pageRequest == null ? 0 : pageRequest.getPageSize();
	}
	
	/**
	 * 获取当前页的记录数。
	 * 
	 * @return
	 */
	public int getSizeOfContent() {
		return content.size();
	}

	/**
	 * 获取总页数。
	 * 
	 * @return
	 */
	public long getTotalPages() {
		return getSize() == 0 ? 1 : (int) Math.ceil((double) totalItems / (double) getSize());
	}

	/**
	 * 获取总记录数。
	 * 
	 * @return
	 */
	public long getTotalItems() {
		return totalItems;
	}
	
	/**
	 * 获取页的内容。
	 * 
	 * @return
	 */
	public List<T> getContent() {
		return content;
	}
}
