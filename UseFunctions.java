class UseFunctions {
	// sizes
	static final int MAX_LINES = 6;
	static final int DEFAULT_WIDTH = 700;
	static final int DEFAULT_HEIGHT = 600;
	static final int ICON_SIZE = 40;
	static final int letter = 20;

	// colours
	static final Color white = new Color(255, 255, 255);
	static final Color DEFAULT_BGG = new Color(121, 102, 108);
	static final Color NOT_IN_WORD_BG = new Color(48, 42, 44);
	static final Color EXISTS_BG = new Color(212, 173, 106);
	static final Color CORRECT_BG = new Color(59, 163, 148);

	// matrixes
	static final char[][] QWERTY = { { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P' },
			{ 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L' }, { 'Z', 'X', 'C', 'V', 'B', 'N', 'M' } };
	static final char[][] tentativa = { { ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ' } };
	static final char[][] secKey = { { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' },
			{ 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' } };

	// metodos

	static void iconeForStats(ColorImage img, int n, int p) {
		for (int i = n; i < n + 600; i++) {
			for (int j = p; j < p + 100; j++) {
				img.setColor(i, j, new Color(0, 0, 0));
			}
		}
	}

	static void iconeForStats2(ColorImage img, int n, int p) {
		for (int i = n; i < n + 400; i++) {
			for (int j = p; j < p + 38; j++) {
				img.setColor(i, j, new Color(0, 0, 0));
			}
		}
	}
	
	static void iconeForStats3(ColorImage img, int n, int p, int s, Color c) {
		for (int i = n; i < n+65*s; i++) {
			for (int j = p; j < p + 35; j++) {
				img.setColor(i, j, c);
			}
		}
	}
	
	static void iconeForStats4(ColorImage img, int n, int p){
		for(int i=n; i<n+55; i++){
			for(int j=p; j<p+35; j++){
				img.setColor(i,j,new Color(50,50,50));
			}
		}
	}
	
	static void iconeStats(ColorImage img, int n, int p, Color color, String c) {//
		String s1 = String.valueOf(c);
		for (int i = n; i < n + 500; i++) {
			for (int j = p; j < p + 50; j++) {
				img.setColor(i, j, color);
			}
		}
		img.drawText(n,p, s1, 30, white);
	}

	static void icone(ColorImage img, int n, int p, Color color, char c) {
		String s1 = String.valueOf(c);
		for (int i = n; i < n + ICON_SIZE; i++) {
			for (int j = p; j < p + ICON_SIZE; j++) {
				img.setColor(i, j, color);
			}
		}
		img.drawText(n + ICON_SIZE / 3, p + ICON_SIZE / 3, s1, letter, white);
	}

	static void Grid(ColorImage img, char[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[0].length; j++) {
				icone(img, 228 + (ICON_SIZE + 4) * j, 50 + (ICON_SIZE + 4) * i, NOT_IN_WORD_BG, v[i][j]);

			}
		}
	}

	static void paintGrid(ColorImage img, char[][] v, String puzzle) {
		char[] c = puzzle.toCharArray();
		char e = c[0];
		char b = c[1];
		char d = c[2];
		char f = c[3];
		char g = c[4];
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[0].length; j++) {
				if (v[i][j] == c[j]) {
					icone(img, 228 + (ICON_SIZE + 4) * j, 50 + (ICON_SIZE + 4) * i, CORRECT_BG, v[i][j]);
				} else if (v[i][j] != e & v[i][j] != b & v[i][j] != d & v[i][j] != f & v[i][j] != g) {
					icone(img, 228 + (ICON_SIZE + 4) * j, 50 + (ICON_SIZE + 4) * i, NOT_IN_WORD_BG, v[i][j]);
				} else {
					icone(img, 228 + (ICON_SIZE + 4) * j, 50 + (ICON_SIZE + 4) * i, EXISTS_BG, v[i][j]);
				}
			}
		}
	}

	static void keyBoard(ColorImage img, char[][] v, int[] c) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				if (c[v[i][j] - 'A'] == 0) {
					icone(img, 150 + (ICON_SIZE + 4) * j, 450 + (ICON_SIZE + 4) * i, DEFAULT_BGG, v[i][j]);
				} else if (c[v[i][j] - 'A'] == 1) {
					icone(img, 150 + (ICON_SIZE + 4) * j, 450 + (ICON_SIZE + 4) * i, NOT_IN_WORD_BG, v[i][j]);
				} else if (c[v[i][j] - 'A'] == 2) {
					icone(img, 150 + (ICON_SIZE + 4) * j, 450 + (ICON_SIZE + 4) * i, EXISTS_BG, v[i][j]);
				} else if (c[v[i][j] - 'A'] == 3) {
					icone(img, 150 + (ICON_SIZE + 4) * j, 450 + (ICON_SIZE + 4) * i, CORRECT_BG, v[i][j]);
				}
			}
		}
	}

	static char[] modString(String s1) {
		char[] c = s1.toCharArray();
		for (int i = 0; i < c.length; i++) {
			c[i] = Character.toUpperCase(c[i]);
			if (c[i] == 'á' || c[i] == 'Á' || c[i] == 'â' || c[i] == 'Â' || c[i] == 'ã' || c[i] == 'Ã' || c[i] == 'à'
					|| c[i] == 'À') {// A
				c[i] = 'A';
			} else if (c[i] == 'ç' || c[i] == 'Ç') {// C
				c[i] = 'C';
			} else if (c[i] == 'é' || c[i] == 'É' || c[i] == 'ê' || c[i] == 'Ê') {// E
				c[i] = 'E';
			} else if (c[i] == 'í' || c[i] == 'Í' || c[i] == 'Ì' || c[i] == 'ì') {// I
				c[i] = 'I';
			} else if (c[i] == 'ó' || c[i] == 'Ó' || c[i] == 'õ' || c[i] == 'Õ' || c[i] == 'ô' || c[i] == 'Ô') {// O
				c[i] = 'O';
			} else if (c[i] == 'ú' || c[i] == 'Ú' || c[i] == 'ù' || c[i] == 'Ù') {// U
				c[i] = 'U';
			}
		}
		return c;
	}
}
