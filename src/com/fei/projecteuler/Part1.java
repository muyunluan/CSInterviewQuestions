package com.fei.projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Part1 {

	// multiples of 3 or 5 
	public static int q001(int num) {
		int i = 0;
		int count = 0;
		while (i < num) {
			if (i % 3 == 0 || i % 5 == 0) {
				count+=i;
			}
			i++;
		}
		return count;
	}


	// even fibonacci numbers
	private static int fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	public static int q002() {
		int sum = 0;
		for(int i = 0; ; i++) {
			int f = fibonacci(i);
			if (f > 4000000) {
				break;
			}
			if (f % 2 == 0) {
				sum += f;
			}
		}
		return sum;
	}

	// largest prime factor
	public static int q003(long num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i = 2; i <= num; i++) {
			while (num % i == 0) {
				factors.add(i);
				//System.out.println(i);
				num /= i;
			}
		}
		Collections.sort(factors);
		return factors.get(factors.size() - 1);
	}

	// largest palindrome product
	private static int reverse(int num) {
		int reverse = 0;
		while (num != 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		return reverse;
	}
	private static boolean isPalindrome(int num) {
		if (num < 0) {
			return false;
		}
		else if (num == 0) {
			return true;
		}
		else {
			if (num == reverse(num)) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public static void q004() {
		int largest = 10000;
		int tem = 10000;
		int a = 100;
		int b = 100;
		for (int i = 100; i< 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				tem = i * j;
				if (isPalindrome(tem) && tem > largest) {
					largest = tem;
					a = i;
					b = j;
					//System.out.println(tem + " = " + i + " * " + j);
				}
			}
		}
		System.out.println(largest + " = " + a + " * " + b);
	}


	// smallest multiple
	private static int findGCD(int x, int y) {
		if (x == 0 || y == 0) {
			return x + y;
		}
		return findGCD(y, x % y);
	}

	public static int q005(int n) {
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum = i / findGCD(i, sum) * sum;
		}
		return sum;
	}

	// sum square difference
	public static int q006(int n) {
		int sumOfSquare = n * (n + 1) * (2 * n + 1) / 6;
		int squareOfSum = (int) Math.pow(n * (2 * 1 + (n - 1) * 1) / 2 , 2);
		return squareOfSum - sumOfSquare;
	}

	// nth prime number
	private static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static int q007(int num) {
		for (int n = 2, count = 0; ; n++) {
			if (isPrime(n)) {
				count++;
				if (count == num) {
					return n;
				}
			}
		}
	}

	// Largest product in a series
	public static long q008(String num, int len) {
		long product = -1;
		for (int i = 0; i <= num.length() - len; i++) {
			long tem = 1;
			for (int j = 0; j < len; j++) {
				tem *= num.charAt(i + j) - '0';
			}
			product = (tem > product) ? tem : product;
		}
		return product;
	}

	// Special Pythagorean triplet
	public static int q009() {
		for (int a = 1; a <= 998; a++) {
			for (int b = 1; b <= 998; b++) {
				if (a + b < 1000) {
					int c = 1000 - a - b;
					if (Math.pow(a , 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
						int product = a * b * c;
						return product;
					}
				}
			}
		}
		return 0;
	}

	// Summation of primes
	public static long q010(int num) {
		long sum = 0;
		for (int i = 2; i <= num; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}

	// Largest product in a grid
	public static int q011() {
		int product = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {

			}
		}
		return product;
	}

	// Highly divisible triangular number
	public static long q012(int num) {
		long sum = 0;
		int count = 0;
		for (int i = 1; ;i++) {
			sum += i;
			count = 0;
			for (int j = 1; j <= sum; j++) {
				if (sum % j == 0) {
					count++;
					if (count >= num) {
						return sum;
					}
				}
			}
		}
	}

	// Large sum
	public static String q013(String[] numbers) {
		BigInteger sum = BigInteger.ZERO;
		for (String tem : numbers) {
			sum = sum.add(new BigInteger(tem));
		}
		return sum.toString().substring(0, 10);
	}

	// Longest Collatz sequence
	public static int q014(int num) {
		int s = 0;
		for (int n = 1; n < num; n++) {
			int count = 0;
			while (n > 1) {
				if (n % 2 == 0) {
					n = n / 2;
				}
				else {
					n = 3 * n + 1;
				}
				count++;
			}
			if (count > s) {
				s = count;
			}
		}
		return s;
	}
	
	// Lattice paths
	// check binomial coefficient
	public static long q015(int n) {
		long path = 1;
		for (int i = 0; i < n; i++) {
			path *= 2 * n - i;
			path /= (i+1);
		}
		return path;
	}
	
	// Power digit sum
	public static int q016(int n) {
		String s = BigInteger.ONE.shiftLeft(n).toString();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		return sum;
	}
	
	// Number letter counts
	private static String[] ONES = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};  // Requires 0 <= n <= 9
	private static String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static String[] TENS = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	private static int tens(int n) {
		int num = 0;
		if (n >= 20) {
			num += TENS[n / 10 - 2].length();
			if (n % 10 != 0) {
				num += ONES[n % 10].length();
			}
		}
		else if (n < 10) {
			num += ONES[n].length();
		}
		else {
			num += TEENS[n % 10].length();
		}
		return num;
	}
	
	public static int q017() {
		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i == 1000) {
				count += 11;//one thousand
			}
			else if (i >= 100) {
				count += (ONES[i / 100].length() + 7);//hundred
				if (i % 100 != 0) {
					count += (tens(i % 100) + 3);
				}
			}
			else {
				count += tens(i);
			}
		}
		return count;
	}
	
	// Counting Sundays
	public static int q019() {
		int count = 0;
		int days = 0;
		for (int i = 1901; i <= 2000; i++) {
			for (int j = 1; j <= 12; j++) {
				if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12 ) {
					days += 31;
				}
				else if (j == 4 || j == 6 || j == 9 || j == 11 ) {
					days += 30;
				}
				else {
					if (i % 100 == 0) {
						if (i % 400 == 0) {
							days += 29;
						}
						else {
							days += 28;
						}
					}
					else {
						if (i % 4 == 0) {
							days += 29;
						}
						else {
							days += 28;
						}
					}
				}
				//find Sundays
				if (days % 7 == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	// Factorial digit sum
	public static int q020(int n) {
		BigInteger t = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			t = t.multiply(BigInteger.valueOf(i));
		}
		System.out.println(t);
		int sum2 = 0;
		char[] digits = t.toString().toCharArray();
		for (char c : digits) {
			sum2 += c - '0';
		}
		return sum2;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//		System.out.println(q001(1000));
		//		System.out.println(q002());
		//		System.out.println(q003(12));
		//		q004();
		//		System.out.println(q005(20));
		//		System.out.println(q006(100));
		//		System.out.println(q007(10001));
		//		String tem = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		//		System.out.println(q008(tem, 13));
		//		System.out.println(q009());
		//		System.out.println(q010(2000000));
		//		System.out.println(q012(500));
		String[] NUMBERS = {
				"37107287533902102798797998220837590246510135740250",
				"46376937677490009712648124896970078050417018260538",
				"74324986199524741059474233309513058123726617309629",
				"91942213363574161572522430563301811072406154908250",
				"23067588207539346171171980310421047513778063246676",
				"89261670696623633820136378418383684178734361726757",
				"28112879812849979408065481931592621691275889832738",
				"44274228917432520321923589422876796487670272189318",
				"47451445736001306439091167216856844588711603153276",
				"70386486105843025439939619828917593665686757934951",
				"62176457141856560629502157223196586755079324193331",
				"64906352462741904929101432445813822663347944758178",
				"92575867718337217661963751590579239728245598838407",
				"58203565325359399008402633568948830189458628227828",
				"80181199384826282014278194139940567587151170094390",
				"35398664372827112653829987240784473053190104293586",
				"86515506006295864861532075273371959191420517255829",
				"71693888707715466499115593487603532921714970056938",
				"54370070576826684624621495650076471787294438377604",
				"53282654108756828443191190634694037855217779295145",
				"36123272525000296071075082563815656710885258350721",
				"45876576172410976447339110607218265236877223636045",
				"17423706905851860660448207621209813287860733969412",
				"81142660418086830619328460811191061556940512689692",
				"51934325451728388641918047049293215058642563049483",
				"62467221648435076201727918039944693004732956340691",
				"15732444386908125794514089057706229429197107928209",
				"55037687525678773091862540744969844508330393682126",
				"18336384825330154686196124348767681297534375946515",
				"80386287592878490201521685554828717201219257766954",
				"78182833757993103614740356856449095527097864797581",
				"16726320100436897842553539920931837441497806860984",
				"48403098129077791799088218795327364475675590848030",
				"87086987551392711854517078544161852424320693150332",
				"59959406895756536782107074926966537676326235447210",
				"69793950679652694742597709739166693763042633987085",
				"41052684708299085211399427365734116182760315001271",
				"65378607361501080857009149939512557028198746004375",
				"35829035317434717326932123578154982629742552737307",
				"94953759765105305946966067683156574377167401875275",
				"88902802571733229619176668713819931811048770190271",
				"25267680276078003013678680992525463401061632866526",
				"36270218540497705585629946580636237993140746255962",
				"24074486908231174977792365466257246923322810917141",
				"91430288197103288597806669760892938638285025333403",
				"34413065578016127815921815005561868836468420090470",
				"23053081172816430487623791969842487255036638784583",
				"11487696932154902810424020138335124462181441773470",
				"63783299490636259666498587618221225225512486764533",
				"67720186971698544312419572409913959008952310058822",
				"95548255300263520781532296796249481641953868218774",
				"76085327132285723110424803456124867697064507995236",
				"37774242535411291684276865538926205024910326572967",
				"23701913275725675285653248258265463092207058596522",
				"29798860272258331913126375147341994889534765745501",
				"18495701454879288984856827726077713721403798879715",
				"38298203783031473527721580348144513491373226651381",
				"34829543829199918180278916522431027392251122869539",
				"40957953066405232632538044100059654939159879593635",
				"29746152185502371307642255121183693803580388584903",
				"41698116222072977186158236678424689157993532961922",
				"62467957194401269043877107275048102390895523597457",
				"23189706772547915061505504953922979530901129967519",
				"86188088225875314529584099251203829009407770775672",
				"11306739708304724483816533873502340845647058077308",
				"82959174767140363198008187129011875491310547126581",
				"97623331044818386269515456334926366572897563400500",
				"42846280183517070527831839425882145521227251250327",
				"55121603546981200581762165212827652751691296897789",
				"32238195734329339946437501907836945765883352399886",
				"75506164965184775180738168837861091527357929701337",
				"62177842752192623401942399639168044983993173312731",
				"32924185707147349566916674687634660915035914677504",
				"99518671430235219628894890102423325116913619626622",
				"73267460800591547471830798392868535206946944540724",
				"76841822524674417161514036427982273348055556214818",
				"97142617910342598647204516893989422179826088076852",
				"87783646182799346313767754307809363333018982642090",
				"10848802521674670883215120185883543223812876952786",
				"71329612474782464538636993009049310363619763878039",
				"62184073572399794223406235393808339651327408011116",
				"66627891981488087797941876876144230030984490851411",
				"60661826293682836764744779239180335110989069790714",
				"85786944089552990653640447425576083659976645795096",
				"66024396409905389607120198219976047599490197230297",
				"64913982680032973156037120041377903785566085089252",
				"16730939319872750275468906903707539413042652315011",
				"94809377245048795150954100921645863754710598436791",
				"78639167021187492431995700641917969777599028300699",
				"15368713711936614952811305876380278410754449733078",
				"40789923115535562561142322423255033685442488917353",
				"44889911501440648020369068063960672322193204149535",
				"41503128880339536053299340368006977710650566631954",
				"81234880673210146739058568557934581403627822703280",
				"82616570773948327592232845941706525094512325230608",
				"22918802058777319719839450180888072429661980811197",
				"77158542502016545090413245809786882778948721859617",
				"72107838435069186155435662884062257473692284509516",
				"20849603980134001723930671666823555245252804609722",
				"53503534226472524250874054075591789781264330331690",
		};
		//System.out.println(q013(NUMBERS));
		//System.out.println(q014(1000000));
		//System.out.println(q015(20));
		//System.out.println(q016(1000));
		//System.out.println(q017());
		//System.out.println(q019());
		System.out.println(q020(100));
	}

}
