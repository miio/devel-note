package LruCacheTest;

import java.util.HashMap;

import org.junit.Ignore;
import org.junit.Test;

import LruCache.*;

 
import static org.junit.Assert.*;


public class LruCacheTest {
	
	@Test	
	public void Get������A�̒��gdataA���������Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		assertEquals("dataA",cache.get("a"));
	}
	
	@Test	
	public void Get������B�̒��gdataB���������Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("b", "dataB");
		assertEquals("dataB",cache.get("b"));
	}
	
	@Test	
	public void Get������C�̒��ghennano���������Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("c", "hennano");
		assertEquals("hennano",cache.get("c"));
	}	
	
	@Test	
	public void A��B������dataA��dataB���������Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		assertEquals("dataA",cache.get("a"));
		assertEquals("dataB",cache.get("b"));
	}
	
	@Ignore
	@Test	
	public void A��B��C������dataB��dataC��null���������Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.put("c", "dataC");
		assertEquals(null,cache.get("a"));
		assertEquals("dataB",cache.get("b"));
		assertEquals("dataC",cache.get("c"));
	}
	
	@Ignore
	@Test
	public void �F�X����čŌ��2���������Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("1", "data1");
		cache.put("2", "data2");
		cache.put("3", "data3");
		cache.put("4", "data4");
		cache.put("5", "data5");
		cache.put("6", "data6");
		cache.put("8", "data7");
		cache.put("7", "data8");
		assertEquals(null,cache.get("6"));
		assertEquals("data7",cache.get("7"));
		assertEquals("data8",cache.get("8"));
	}
	
	@Test
	public void A����ꂽ��z��ԍ�0���A���Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		assertEquals(0,cache.getOrder("a"));
	}
	
	@Test
	public void A��B����ꂽ��A�̔z��ԍ���0��B�̔z��ԍ���1�Ƃ��ċA���Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		assertEquals(0,cache.getOrder("a"));
		assertEquals(1,cache.getOrder("b"));
	}
	
	@Test
	public void ��ԌÂ��̂�����(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.put("c", "dataC");
		cache.deleteOld();
		assertEquals(-1,cache.getOrder("a"));
	}
	
	
	
	@Test
	public void A��B��C����ꂽ��A�̔z��ԍ����}�C�i�X1��B�̔z��ԍ���0��C�̔z��ԍ���1�Ƃ��ċA���Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.put("c", "dataC");
		assertEquals(-1,cache.getOrder("a"));
		assertEquals(0,cache.getOrder("b"));
		assertEquals(1,cache.getOrder("c"));
	}
	
	@Test
	public void ABAC�Ƃ��ꂽ��B��������A��C�����R���ŋA���Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.put("a", "dataA");
		cache.put("c", "dataC");
		assertEquals(0,cache.getOrder("a"));
		assertEquals(-1,cache.getOrder("b"));
		assertEquals(1,cache.getOrder("c"));
	}
	
	@Test
	public void AB�����A�Ă��C���ꂽ��B��������A��C�����R���ŋA���Ă���(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.get("a");
		cache.put("c", "dataC");
		assertEquals(0,cache.getOrder("a"));
		assertEquals(-1,cache.getOrder("b"));
		assertEquals(1,cache.getOrder("c"));
	}
	
	@Test
	public void �z��T�C�Y�T�Ƃ���ABCD�����C�Ă��DE���ꂽ(){
		LruCache cache = new LruCache(4);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.put("c", "dataC");
		cache.put("d", "dataD");
		cache.get("c");
		cache.put("d", "dataD");
		cache.put("e", "dataE");
		assertEquals(-1,cache.getOrder("a"));
		assertEquals(0,cache.getOrder("b"));
		assertEquals(2,cache.getOrder("d"));
		assertEquals(1,cache.getOrder("c"));
		assertEquals(3,cache.getOrder("e"));
	}
	
	
}
