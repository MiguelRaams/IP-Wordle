class Stats {

	int[] c = { ' ', ' ', ' ', ' ', ' ', ' ' };
	int plays = 0;
	int wins = 0;
	int percentage = 0;
	int consecutiveWins = 0;
	int winStreak = 0;

	int win1 = 0;
	int win2 = 0;
	int win3 = 0;
	int win4 = 0;
	int win5 = 0;
	int win6 = 0;
	int losses = 0;
	ColorImage img = new ColorImage(700, 700);

	// construtor

	Stats() {
		img.drawText(200, 40, "ESTATÍSTICAS", 40, new Color(255, 255, 255));
		img.drawText(60, 180, "Jogados", 30, new Color(150, 150, 150));
		img.drawText(200, 180, "% vitórias", 30, new Color(150, 150, 150));
		img.drawText(360, 180, "Sequência", 30, new Color(150, 150, 150));
		img.drawText(540, 180, "Melhor", 30, new Color(150, 150, 150));
		img.drawText(365, 210, "de vitórias", 30, new Color(150, 150, 150));
		img.drawText(520, 210, "sequência", 30, new Color(150, 150, 150));
		img.drawText(190, 250, "Distribuição de tentativas", 30, new Color(255, 255, 255));
		img.drawText(200, 300, "1", 30, new Color(255, 255, 255));
		img.drawText(200, 350, "2", 30, new Color(255, 255, 255));
		img.drawText(200, 400, "3", 30, new Color(255, 255, 255));
		img.drawText(200, 450, "4", 30, new Color(255, 255, 255));
		img.drawText(200, 500, "5", 30, new Color(255, 255, 255));
		img.drawText(200, 550, "6", 30, new Color(255, 255, 255));
		img.drawText(200, 600, "X", 30, new Color(255, 255, 255));
		img.drawCenteredText(100, 155, plays + "", 100, new Color(255, 255, 255));
		img.drawCenteredText(240, 155, percentage + "", 100, new Color(255, 255, 255));
		img.drawCenteredText(410, 155, consecutiveWins + "", 100, new Color(255, 255, 255));
		img.drawCenteredText(565, 155, winStreak + "", 100, new Color(255, 255, 255));
		UseFunctions.iconeForStats4(img, 230, 285);
		UseFunctions.iconeForStats4(img, 230, 335);
		UseFunctions.iconeForStats4(img, 230, 385);
		UseFunctions.iconeForStats4(img, 230, 435);
		UseFunctions.iconeForStats4(img, 230, 485);
		UseFunctions.iconeForStats4(img, 230, 535);
		UseFunctions.iconeForStats4(img, 230, 585);
		img.drawText(250, 300, win1 + "", 30, new Color(255, 255, 255));
		img.drawText(250, 350, win2 + "", 30, new Color(255, 255, 255));
		img.drawText(250, 400, win3 + "", 30, new Color(255, 255, 255));
		img.drawText(250, 450, win4 + "", 30, new Color(255, 255, 255));
		img.drawText(250, 500, win5 + "", 30, new Color(255, 255, 255));
		img.drawText(250, 550, win6 + "", 30, new Color(255, 255, 255));
		img.drawText(250, 600, losses + "", 30, new Color(255, 255, 255));

	}

	// metodos

	void trysDistribuition(int p) {
		if (p == 0) {
			win1++;
			UseFunctions.iconeForStats2(img, 215, 284);
			UseFunctions.iconeForStats3(img, 230, 284, win1, new Color(255, 0, 0));
			img.drawText(250, 300, win1 + "", 30, new Color(255, 255, 255));
		} else if (p == 1) {
			win2++;
			UseFunctions.iconeForStats2(img, 215, 334);
			UseFunctions.iconeForStats3(img, 230, 334, win2, new Color(255, 0, 0));
			img.drawText(250, 350, win2 + "", 30, new Color(255, 255, 255));
		} else if (p == 2) {
			win3++;
			UseFunctions.iconeForStats2(img, 215, 384);
			UseFunctions.iconeForStats3(img, 230, 384, win3, new Color(255, 0, 0));
			img.drawText(250, 400, win3 + "", 30, new Color(255, 255, 255));
		} else if (p == 3) {
			win4++;
			UseFunctions.iconeForStats2(img, 215, 434);
			UseFunctions.iconeForStats3(img, 230, 434, win4, new Color(255, 0, 0));
			img.drawText(250, 450, win4 + "", 30, new Color(255, 255, 255));
		} else if (p == 4) {
			win5++;
			UseFunctions.iconeForStats2(img, 215, 484);
			UseFunctions.iconeForStats3(img, 230, 484, win5, new Color(255, 0, 0));
			img.drawText(250, 500, win5 + "", 30, new Color(255, 255, 255));
		} else if (p == 5) {
			win6++;
			UseFunctions.iconeForStats2(img, 220, 534);
			UseFunctions.iconeForStats3(img, 230, 534, win6, new Color(255, 0, 0));
			img.drawText(250, 550, win6 + "", 30, new Color(255, 255, 255));
		}
	}

	void result(int p, boolean n) {
		plays++;
		if (n) {
			wins++;
			consecutiveWins++;
			trysDistribuition(p);
			if (consecutiveWins > winStreak) {
				winStreak = consecutiveWins;
			}
		} else {
			losses++;
			UseFunctions.iconeForStats2(img, 220, 584);
			UseFunctions.iconeForStats3(img, 230, 584, losses, new Color(255, 0, 0));
			img.drawText(250, 600, losses + "", 30, new Color(255, 255, 255));
			consecutiveWins = 0;
		}
		percentage = calcPercentage(wins, plays);
		UseFunctions.iconeForStats(img, 80, 70);
		img.drawCenteredText(90, 155, plays + "", 100, new Color(255, 255, 255));
		if (percentage == 0) {
			img.drawCenteredText(215, 155, percentage + "", 100, new Color(255, 255, 255));
		} else if (percentage > 99) {
			img.drawCenteredText(185, 155, percentage + "", 100, new Color(255, 255, 255));
		} else {
			img.drawCenteredText(220, 155, percentage + "", 100, new Color(255, 255, 255));
		}
		img.drawCenteredText(410, 155, consecutiveWins + "", 100, new Color(255, 255, 255));
		img.drawCenteredText(570, 155, winStreak + "", 100, new Color(255, 255, 255));
	}

	static double percentage(int n, int total) {
		return (double) n / total;
	}

	static int calcPercentage(int i, int j) {
		double n = percentage(i, j);
		double p = n * 100;
		int s = (int) (p);
		return s;
	}
}
