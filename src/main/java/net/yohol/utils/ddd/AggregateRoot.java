/**
 * 
 */
package net.yohol.utils.ddd;

/**
 * 聚合
 * @author Jo
 *
 */
public abstract class AggregateRoot extends Entity {
	private static final long serialVersionUID = 1L;
	
	private int version;
	
	/**
	 * 触发领域事件
	 * @param event
	 */
	public abstract void causes(Object event);

	public int getVersion() {
		return version;
	}

	protected void setVersion(int version) {
		this.version = version;
	}
}
