package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class G {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		int n = ni(), Q = ni();
		int[] ds = na(n-1);
		int[] gs = new int[n];
		int[] ps = new int[n];
		for(int i = 0;i < n;i++){
			gs[i] = ni();
			ps[i] = ni();
		}
		int[][] qs = new int[Q][];
		for(int i = 0;i < Q;i++){
			qs[i] = new int[]{ni()-1, ni()-1, i, -1};
		}
		Arrays.sort(qs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		for(int i = 0;i < Q;i++)qs[i][3] = i;
		
		int[][] eqs = Arrays.copyOf(qs, Q);
		Arrays.sort(eqs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		
		for(int i = 0;i < n-1;i++){
			ds[i] -= gs[i];
		}
		
		long[] ans = new long[Q];
		Arrays.fill(ans, -1);
		
		int[][] minps = new int[Q][];
		int ms = 0;
		
		long[][] rems = new long[Q][];
		int rp = 0;
		long baserem = 0;
		
		long[] liters = new long[Q+2];
		long[] fanss = new long[Q+2];
		
		int p = 0;
		int e = 0;
		LST literBounds = new LST(Q+3);
		for(int i = 0;i < n;i++){
			while(e < Q && eqs[e][1] <= i){
				if(eqs[e][1] == eqs[e][0]){
					ans[eqs[e][2]] = 0;
				}else{
//					tr("las", sumFenwick(fanss, eqs[e][3]),
//							choose(minps, ms, eqs[e][3])[0],sumFenwick(liters, eqs[e][3]));

					// answer
					ans[eqs[e][2]] = sumFenwick(fanss, eqs[e][3]) + 
							choose(minps, ms, eqs[e][3])[0] * sumFenwick(liters, eqs[e][3]);
				}
				e++;
			}
			if(i == n-1)break;
			
			int op = p;
			while(p < Q && qs[p][0] <= i){
				p++;
			}
			if(op < p){
				rems[rp++] = new long[]{-baserem, p-op};
			}
			
			int pnum = p-op;
			int pptr = op;
			while(ms > 0 && ps[i] <= minps[ms-1][0]){
				pnum += minps[ms-1][1];
				pptr -= minps[ms-1][1];
//				tr("pptr", pptr);
				literBounds.set(pptr);
				while(true){
					int pos = literBounds.next(pptr);
					if(pos == -1)break;
					int nex = literBounds.next(pos+1);
//					tr("posnex", pos, nex, literBounds);
					if(nex != -1){
						long del = sumFenwick(liters, pos);
//						tr("del", del, i, minps[ms-1][0]);
						if(del != 0){
							addFenwick(fanss, pos, del*minps[ms-1][0]);
							addFenwick(fanss, nex, -del*minps[ms-1][0]);
							addFenwick(liters, pos, -del);
							addFenwick(liters, nex, del);
						}
						literBounds.unset(pos);
					}else{
						literBounds.unset(pos);
						break;
					}
				}
				literBounds.set(pptr);
				ms--;
			}
			if(pnum > 0){
				minps[ms++] = new int[]{ps[i], pnum, p-pnum};
			}
			
			if(ds[i] <= 0){
				baserem -= ds[i];
			}else{
				long num = 0;
				int ptr = p;
				while(rp > 0){
					if(rems[rp-1][0] + baserem <= ds[i]){
						num += rems[rp-1][1];
						addFenwick(liters, (int)(ptr-rems[rp-1][1]), ds[i] - (rems[rp-1][0] + baserem));
						addFenwick(liters, ptr, -(ds[i] - (rems[rp-1][0] + baserem)));
						literBounds.set((int)(ptr-rems[rp-1][1]));
						literBounds.set(ptr);
						ptr -= rems[rp-1][1];
						rp--;
					}else{
						break;
					}
				}
				baserem -= ds[i];
				if(num > 0){
					rems[rp++] = new long[]{-baserem, num};
				}
			}
//			tr("FL", restoreFenwick(liters));
			
			
//			tr(baserem, Arrays.copyOf(rems, rp));
			
//			tr(restoreFenwick(liters));
//			tr("minps", Arrays.copyOf(minps, ms));
		}
		
		for(long ret : ans){
			out.println(ret);
		}
	}
	
	public static long[] restoreFenwick(long[] ft)
	{
		int n = ft.length-1;
		long[] ret = new long[n];
		for(int i = 0;i < n;i++)ret[i] = sumFenwick(ft, i);
		for(int i = n-1;i >= 1;i--)ret[i] -= ret[i-1];
		return ret;
	}
	
	int[] choose(int[][] rs, int sup, int id)
	{
		int low = 0, high = sup;
		while(high - low > 1){
			int h = high+low>>1;
			if(rs[h][2] <= id){
				low = h;
			}else{
				high = h;
			}
		}
		return rs[low];
	}
	
	public static class LST {
		public long[][] set;
		public int n;
//		public int size;
		
		public LST(int n) {
			this.n = n;
			int d = 1;
			for(int m = n;m > 1;m>>>=6, d++);
			
			set = new long[d][];
			for(int i = 0, m = n>>>6;i < d;i++, m>>>=6){
				set[i] = new long[m+1];
			}
//			size = 0;
		}
		
		// [0,r)
		public LST setRange(int r)
		{
			for(int i = 0;i < set.length;i++, r=r+63>>>6){
				for(int j = 0;j < r>>>6;j++){
					set[i][j] = -1L;
				}
				if((r&63) != 0)set[i][r>>>6] |= (1L<<r)-1;
			}
			return this;
		}
		
		// [0,r)
		public LST unsetRange(int r)
		{
			if(r >= 0){
				for(int i = 0;i < set.length;i++, r=r+63>>>6){
					for(int j = 0;j < r+63>>>6;j++){
						set[i][j] = 0;
					}
					if((r&63) != 0)set[i][r>>>6] &= ~((1L<<r)-1);
				}
			}
			return this;
		}
		
		public LST set(int pos)
		{
			if(pos >= 0 && pos < n){
//				if(!get(pos))size++;
				for(int i = 0;i < set.length;i++, pos>>>=6){
					set[i][pos>>>6] |= 1L<<pos;
				}
			}
			return this;
		}
		
		public LST unset(int pos)
		{
			if(pos >= 0 && pos < n){
//				if(get(pos))size--;
				for(int i = 0;i < set.length && (i == 0 || set[i-1][pos] == 0L);i++, pos>>>=6){
					set[i][pos>>>6] &= ~(1L<<pos);
				}
			}
			return this;
		}
		
		public boolean get(int pos)
		{
			return pos >= 0 && pos < n && set[0][pos>>>6]<<~pos<0;
		}
		
		public int prev(int pos)
		{
			for(int i = 0;i < set.length && pos >= 0;i++, pos>>>=6, pos--){
				int pre = prev(set[i][pos>>>6], pos&63);
				if(pre != -1){
					pos = pos>>>6<<6|pre;
					while(i > 0)pos = pos<<6|63-Long.numberOfLeadingZeros(set[--i][pos]);
					return pos;
				}
			}
			return -1;
		}
		
		public int next(int pos)
		{
			for(int i = 0;i < set.length && pos>>>6 < set[i].length;i++, pos>>>=6, pos++){
				int nex = next(set[i][pos>>>6], pos&63);
				if(nex != -1){
					pos = pos>>>6<<6|nex;
					while(i > 0)pos = pos<<6|Long.numberOfTrailingZeros(set[--i][pos]);
					return pos;
				}
			}
			return -1;
		}
		
		private static int prev(long set, int n)
		{
			long h = Long.highestOneBit(set<<~n);
			if(h == 0L)return -1;
			return Long.numberOfTrailingZeros(h)-(63-n);
		}
		
		private static int next(long set, int n)
		{
			long h = Long.lowestOneBit(set>>>n);
			if(h == 0L)return -1;
			return Long.numberOfTrailingZeros(h)+n;
		}
		
		@Override
		public String toString()
		{
			List<Integer> list = new ArrayList<Integer>();
			for(int pos = next(0);pos != -1;pos = next(pos+1)){
				list.add(pos);
			}
			return list.toString();
		}
	}

	
	public static long sumFenwick(long[] ft, int i)
	{
		long sum = 0;
		for(i++;i > 0;i -= i&-i)sum += ft[i];
		return sum;
	}
	
	public static void addFenwick(long[] ft, int i, long v)
	{
		if(v == 0)return;
		int n = ft.length;
		for(i++;i < n;i += i&-i)ft[i] += v;
	}
	
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new G().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}