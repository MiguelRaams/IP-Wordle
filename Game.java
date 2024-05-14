class Game {
	final Color DEFAULT_BG = new Color(111, 92, 98);
	
	ColorImage img = new ColorImage(700, 600);
	
	char[][] game = { { ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' } };

	char[][] secKey = { { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' },
			{ 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' } };

	String puzzle = puzzle();

	Dictionary dicionario = new Dictionary("pt_br.txt");

	int[] state = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	int[] alfa = { 'A' - 'A', 'B' - 'A', 'C' - 'A', 'D' - 'A', 'E' - 'A', 'F' - 'A', 'G' - 'A', 'H' - 'A', 'I' - 'A',
			'J' - 'A', 'K' - 'A', 'L' - 'A', 'M' - 'A', 'N' - 'A', 'O' - 'A', 'P' - 'A', 'Q' - 'A', 'R' - 'A',
			'S' - 'A', 'T' - 'A', 'U' - 'A', 'V' - 'A', 'W' - 'A', 'X' - 'A', 'Y' - 'A', 'Z' - 'A' };

	int jogada = 0;

	Stats wordl = new Stats();
	
	boolean b = false;

	// construtores

	Game(ColorImage img) {
		if (img == null) {
			throw new NullPointerException("img can't be null");
		}
		Dictionary dicionario = new Dictionary("pt_br.txt");
	}

	Game(Dictionary dicionário) {
		for (int i = 0; i < 700; i++) {
			for (int j = 0; j < 600; j++) {
				img.setColor(i, j, DEFAULT_BG);
			}
		}
		UseFunctions.Grid(img, game);
		UseFunctions.keyBoard(img, secKey, state);
	}

	// métodos

	String puzzle() {
		Dictionary dicionario = new Dictionary("pt_br.txt");
		String s1 = dicionario.generateSecretWord(5);
		return s1;
	}

	int[] saveState(int p) {
		char[] c = puzzle.toCharArray();
		char v = c[0];
		char b = c[1];
		char d = c[2];
		char f = c[3];
		char g = c[4];
		for (int i = 0; i < game.length; i++) {
			if (i == p) {
				for (int j = 0; j < game[0].length; j++) {
					if (game[i][j] == c[j]) {
						state[alfa[game[i][j] - 'A']] = 3;
					} else if (game[i][j] != v & game[i][j] != b & game[i][j] != d & game[i][j] != f
							& game[i][j] != g) {
						state[alfa[game[i][j] - 'A']] = 1;
					} else {
						state[alfa[game[i][j] - 'A']] = 2;
					}
				}
			}
		}
		return state;
	}

	void play(String word) {
		char[] d=UseFunctions.modString(word);
		String s = new String(d);
		if (b == true) {
			throw new IllegalStateException("please restart");
		} else {
			if (!dicionario.exists(s)) {
				throw new IllegalArgumentException("not a word");
			} else {
				if (s.equals(puzzle)) {
					insert(s, jogada);
					saveState(jogada);
					upDateState(jogada);
					wordl.result(jogada, true);
					b = true;
				} else {
					if (jogada == 5) {
						insert(s, jogada);
						saveState(jogada);
						upDateState(jogada);
						wordl.result(jogada, false);
					} else {
						insert(s, jogada);
						saveState(jogada);
						upDateState(jogada);
					}
				}
				jogada++;
			}
		}
	}

	void restart() {
		b=false;
		jogada = 0;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[0].length; j++) {
				game[i][j] = ' ';
			}
		}
		for (int n = 0; n < 26; n++) {
			state[n] = 0;
		}
		UseFunctions.Grid(img, game);
		UseFunctions.keyBoard(img, secKey, state);
		puzzle = puzzle();

	}

	void upDateState(int p) {
		UseFunctions.keyBoard(img, secKey, state);
		UseFunctions.paintGrid(img, game, puzzle);
	}

	void insert(String s1, int n) {
		char[] word = UseFunctions.modString(s1);
		for (int j = 0; j < game[0].length; j++) {
			game[n][j] = word[j];
		}
		UseFunctions.Grid(img, game);
	}
}