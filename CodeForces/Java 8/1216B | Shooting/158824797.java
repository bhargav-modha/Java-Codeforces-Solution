import java.io.*;
import java.util.*;
 
public class B_Shooting {
 public static void main(String[] args) {
  MyScanner sc = new MyScanner();
  out = new PrintWriter(new BufferedOutputStream(System.out));
 
  int n = sc.nextInt();
  Pair[] p = new Pair[n];
  for (int i = 0; i < n; ++i) {
   int d = sc.nextInt();
   p[i] = new Pair(d, i);
  }
  Arrays.sort(p);
  long ans = 0;
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < n; ++i) {
   int d = p[i].first, k = p[i].second;
   ans += (d * i + 1);
   sb.append(k + 1 + " ");
  }
  out.println(ans);
  out.println(sb);
  out.close();
 }
 
 public static PrintWriter out;
 public static long mod = (long) 1e9 + 7;
 
 public static class MyScanner {
 
  BufferedReader br;
  StringTokenizer st;
 
  public MyScanner() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }
 
  String next() {
   while (st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }
 
  int nextInt() {
   return Integer.parseInt(next());
  }
 
  long nextLong() {
   return Long.parseLong(next());
  }
 
  double nextDouble() {
   return Double.parseDouble(next());
  }
 
  int[] readArray(int n) {
   int a[] = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }
 
  long[] readLongArray(int n) {
   long a[] = new long[n];
   for (int i = 0; i < n; i++)
    a[i] = nextLong();
   return a;
  }
 
  String nextLine() {
   String str = "";
   try {
    str = br.readLine();
   } catch (IOException e) {
    e.printStackTrace();
   }
   return str;
  }
 }
 
 static void SieveOfEratosthenes(int n, boolean prime[]) {
  prime[0] = false;
  prime[1] = false;
 
  for (int p = 2; p * p <= n; p++) {
   if (prime[p] == true)
    for (int i = p * p; i <= n; i += p)
     prime[i] = false;
  }
 }
 
 static void dfs(int root, boolean[] vis, int[] value, ArrayList[] gr, int prev) {
  vis[root] = true;
  value[root] = 3 - prev;
  prev = 3 - prev;
  for (int i = 0; i < gr[root].size(); i++) {
   int next = (int) gr[root].get(i);
   if (!vis[next])
    dfs(next, vis, value, gr, prev);
  }
 }
 
 static boolean isPrime(int n) {
  for (int i = 2; i <= Math.sqrt(n); i++)
   if (n % i == 0)
    return false;
  return true;
 }
 
 static boolean isPrime(long n) {
  for (long i = 2; i <= Math.sqrt(n); i++)
   if (n % i == 0)
    return false;
  return true;
 }
 
 static int abs(int a) {
  return a > 0 ? a : -a;
 }
 
 static int max(int a, int b) {
  return a > b ? a : b;
 }
 
 static int min(int a, int b) {
  return a < b ? a : b;
 }
 
 static long pow(long n, long m) {
  if (m == 0)
   return 1;
  long temp = pow(n, m / 2);
  long res = ((temp * temp) % mod);
  if (m % 2 == 0)
   return res;
  return (res * n) % mod;
 }
 
 static long modular_add(long a, long b) {
  return ((a % mod) + (b % mod)) % mod;
 }
 
 static long modular_sub(long a, long b) {
  return ((a % mod) - (b % mod) + mod) % mod;
 }
 
 static long modular_mult(long a, long b) {
  return ((a % mod) * (b % mod)) % mod;
 }
 
 static long lcm(int a, int b) {
  return (a / gcd(a, b)) * b;
 }
 
 static long gcd(long a, long b) {
  if (b == 0) {
   return a;
  }
  return gcd(b, a % b);
 }
 
 static int gcd(int n1, int n2) {
  if (n2 != 0)
   return gcd(n2, n1 % n2);
  else
   return n1;
 }
 
 static class Pair implements Comparable<Pair> {
  int first, second;
 
  public Pair(int first, int second) {
   super();
   this.first = first;
   this.second = second;
  }
 
  @Override
  public int compareTo(Pair o) {
   return this.first != o.first ? o.first - this.first : o.second - this.second;
  }
 
  @Override
  public int hashCode() {
   final int prime = 31;
   int result = 1;
   result = prime * result + first;
   result = prime * result + second;
   return result;
  }
 
  @Override
  public boolean equals(Object obj) {
   if (this == obj)
    return true;
   if (obj == null)
    return false;
   if (getClass() != obj.getClass())
    return false;
   Pair other = (Pair) obj;
   if (first != other.first)
    return false;
   if (second != other.second)
    return false;
   return true;
  }
 }
 
 static void sort(int[] a) {
  ArrayList<Integer> list = new ArrayList<>();
  for (int i : a)
   list.add(i);
  Collections.sort(list);
  for (int i = 0; i < a.length; i++)
   a[i] = list.get(i);
 }
 
 static void sort(long a[]) {
  ArrayList<Long> list = new ArrayList<>();
  for (long i : a)
   list.add(i);
  Collections.sort(list);
  for (int i = 0; i < a.length; i++)
   a[i] = list.get(i);
 }
 
 static int[] array(int n, int value) {
  int a[] = new int[n];
  for (int i = 0; i < n; i++)
   a[i] = value;
  return a;
 }
 
 static long sum(long a[]) {
  long sum = 0;
  for (long i : a)
   sum += i;
  return (sum);
 }
 
 static long count(long a[], long x) {
  long c = 0;
  for (long i : a)
   if (i == x)
    c++;
  return (c);
 }
 
 static int sum(int a[]) {
  int sum = 0;
  for (int i : a)
   sum += i;
  return (sum);
 }
 
 static int count(int a[], int x) {
  int c = 0;
  for (int i : a)
   if (i == x)
    c++;
  return (c);
 }
 
 static int count(String s, char ch) {
  int c = 0;
  char x[] = s.toCharArray();
  for (char i : x)
   if (ch == i)
    c++;
  return (c);
 }
 
 static int[] freq(int a[], int n) {
  int f[] = new int[n + 1];
  for (int i : a)
   f[i]++;
  return f;
 }
 
 static int[] pos(int a[], int n) {
  int f[] = new int[n + 1];
  for (int i = 0; i < n; i++)
   f[a[i]] = i;
  return f;
 }
 
 static boolean isPalindrome(String s) {
  StringBuilder sb = new StringBuilder();
  sb.append(s);
  String str = String.valueOf(sb.reverse());
  if (s.equals(str))
   return true;
  else
   return false;
 }
}