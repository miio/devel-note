package LruCacheTest;

import java.util.HashMap;

import org.junit.Ignore;
import org.junit.Test;

import LruCache.*;

 
import static org.junit.Assert.*;


public class LruCacheTest {
	
	@Test	
	public void GetしたらAの中身dataAがかえってくる(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		assertEquals("dataA",cache.get("a"));
	}
	
	@Test	
	public void GetしたらBの中身dataBがかえってくる(){
		LruCache cache = new LruCache(2);
		cache.put("b", "dataB");
		assertEquals("dataB",cache.get("b"));
	}
	
	@Test	
	public void GetしたらCの中身hennanoがかえってくる(){
		LruCache cache = new LruCache(2);
		cache.put("c", "hennano");
		assertEquals("hennano",cache.get("c"));
	}	
	
	@Test	
	public void AとBを入れてdataAとdataBがかえってくる(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		assertEquals("dataA",cache.get("a"));
		assertEquals("dataB",cache.get("b"));
	}
	
	@Ignore
	@Test	
	public void AとBとCを入れてdataBとdataCとnullがかえってくる(){
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
	public void 色々入れて最後の2つがかえってくる(){
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
	public void Aを入れたら配列番号0が帰ってくる(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		assertEquals(0,cache.getOrder("a"));
	}
	
	@Test
	public void AとBを入れたらAの配列番号が0でBの配列番号が1として帰ってくる(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		assertEquals(0,cache.getOrder("a"));
		assertEquals(1,cache.getOrder("b"));
	}
	
	@Test
	public void 一番古いのを消す(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.put("c", "dataC");
		cache.deleteOld();
		assertEquals(-1,cache.getOrder("a"));
	}
	
	
	
	@Test
	public void AとBとCを入れたらAの配列番号がマイナス1でBの配列番号が0でCの配列番号が1として帰ってくる(){
		LruCache cache = new LruCache(2);
		cache.put("a", "dataA");
		cache.put("b", "dataB");
		cache.put("c", "dataC");
		assertEquals(-1,cache.getOrder("a"));
		assertEquals(0,cache.getOrder("b"));
		assertEquals(1,cache.getOrder("c"));
	}
	
	@Test
	public void ABACといれたらBが抜けてAとCが自然数で帰ってくる(){
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
	public void AB入れてA呼んでC入れたらBが抜けてAとCが自然数で帰ってくる(){
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
	public void 配列サイズ５としてABCD入れてC呼んでDE入れた(){
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
