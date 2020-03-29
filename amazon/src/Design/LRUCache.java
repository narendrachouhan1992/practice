package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
	public class CacheEntry
	{
		private int arrayIndex;
		private String key;
		private String Value;
		public CacheEntry(int arrayIndex, String key, String value) {
			super();
			this.arrayIndex = arrayIndex;
			this.key = key;
			Value = value;
		}
		public int getArrayIndex() {
			return arrayIndex;
		}
		public void setArrayIndex(int arrayIndex) {
			this.arrayIndex = arrayIndex;
		}
		public String getKey() {
			return key;
		}
		public String getValue() {
			return Value;
		}
	}
	private Map<String, CacheEntry> cache = new HashMap<String, LRUCache.CacheEntry>();
	private List<CacheEntry> keyList = new ArrayList<LRUCache.CacheEntry>();
	int capacity;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	public LRUCache() {
		capacity=10;
	}
	public void put(String key, String value)
	{
		if(cache.containsKey(key))
		{
			CacheEntry ce = cache.get(key);
			keyList.remove(ce.getArrayIndex());
			ce.setArrayIndex(keyList.size());
			keyList.add(keyList.size(), ce);
		}
		else
		{
			cleanIfLimitReached();
			
			CacheEntry ce = new CacheEntry(cache.size(), key, value);
			cache.put(key, ce);
			keyList.add(keyList.size(), ce);
			
		}
	}
	String get(String key)
	{
		if(cache.containsKey(key))
		{
			String val = cache.get(key).Value;
			put(key, val);
			return val;
		}
		return null;
	}
	void cleanIfLimitReached()
	{
		if(keyList.size()==capacity)
		{
			cache.remove(keyList.get(0).key);
			keyList.remove(0);
			
		}
	}
	
}
