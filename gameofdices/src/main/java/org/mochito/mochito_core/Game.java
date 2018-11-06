package org.mochito.mochito_core;

import java.util.Optional;

	public class Game {

		private Player left;
		private Player right;

		public Game(Player left, Player right) {
			this.left = left;
			this.right = right;
		}

		public Optional<Player> play() {
			int counter = 0;
			while (counter < 5) {
				left.play();
				int leftValue = left.getLastValue().get();
				right.play();
				int rightValue = right.getLastValue().get();

				if (leftValue > rightValue) {
					System.out.println("Le vainqueur est : "+left.getName());
					return Optional.of(left);
					
				} else if (rightValue > rightValue) {
					System.out.println("Le vainqueur est : "+right.getName());
					return Optional.of(right);
					
					
				}

				counter++;
			}
			return Optional.empty();
		}
	}