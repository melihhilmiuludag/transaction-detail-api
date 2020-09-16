package tr.mhu.core.service.Cache;

/**
 * @author muludag on 16.09.2020
 */
public interface IMhuCoreCache {
	void add(String key, Object value, long periodInMillis);

	void remove(String key);

	Object get(String key);

	void clear();

	long size();
}
