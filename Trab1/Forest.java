package pkg;

import java.util.ArrayList;

public class Forest {

	private ArrayList<Pot> pots = new ArrayList<Pot>();
	private Hunter winner;

	public Forest() {
		StartPots();
	}
	//!método para retornar a posição de um pote passado como parametro.
	public int PotAt(Pot pot) {
		return pots.lastIndexOf(pot);
	}
	//!método para retornar um pote de uma determinada posição do arraylist de potes.
	public Pot getPot(int _index) {
		return pots.get(_index);
	}

	//!método para adicionar uma moeda a um determinado pote do arraylist de potes.
	public void AddCoin(int index) {
		pots.get(index).setCoins(pots.get(index).getCoins() + 1);
	}
	//!método para pegar a moeda em um determinado pote se tiver moedas nele.
	public int CatchCoins(Pot pote) {
		if (pote.getCoins() <= 0) {
			return 0;
		} else if (pote.getCoins() == 1) {
			pote.setCoins(pote.getCoins() - 1);
			return 1;
		} else {
			pote.setCoins(pote.getCoins() - 3);
			return 3;
		}
	}
	//!método para setar o caçador vencedor.
	public void setWinner(Hunter _hunter) {
		winner = _hunter;
	}
	//!Método para retornar o caçador vencedor.
	public Hunter getWinner() {
		return winner;
	}
	//!método para printar o caçador vencedor.
	public void PrintWinner() {
		System.out.println("-- -- -- -- -- -- VENCEDOR -- -- -- -- -- -- ");
		System.out.println("Cachorros e Caçador da cor: " +winner.getStringColor()+ ", Moedas: " +winner.getTotalCoin());
	}
	//!método para ajustar os possiveis caminhos que um cachorro pode tomar.
	public void StartPots() {
		for (int i = 0; i < 20; i++) {
			Pot aux = new Pot();
			pots.add(aux);
		}
		pots.get(0).setPossiblePaths(pots.get(1));
		pots.get(0).setPossiblePaths(pots.get(14));
		pots.get(1).setPossiblePaths(pots.get(0));
		pots.get(1).setPossiblePaths(pots.get(2));
		pots.get(1).setPossiblePaths(pots.get(3));
		pots.get(1).setPossiblePaths(pots.get(4));
		pots.get(2).setPossiblePaths(pots.get(1));
		pots.get(2).setPossiblePaths(pots.get(8));
		pots.get(3).setPossiblePaths(pots.get(1));
		pots.get(3).setPossiblePaths(pots.get(8));
		pots.get(3).setPossiblePaths(pots.get(9));
		pots.get(4).setPossiblePaths(pots.get(1));
		pots.get(4).setPossiblePaths(pots.get(5));
		pots.get(5).setPossiblePaths(pots.get(4));
		pots.get(5).setPossiblePaths(pots.get(6));
		pots.get(5).setPossiblePaths(pots.get(6));
		pots.get(6).setPossiblePaths(pots.get(5));
		pots.get(7).setPossiblePaths(pots.get(5));
		pots.get(8).setPossiblePaths(pots.get(2));
		pots.get(8).setPossiblePaths(pots.get(3));
		pots.get(8).setPossiblePaths(pots.get(14));
		pots.get(8).setPossiblePaths(pots.get(17));
		pots.get(9).setPossiblePaths(pots.get(3));
		pots.get(9).setPossiblePaths(pots.get(11));
		pots.get(10).setPossiblePaths(pots.get(11));
		pots.get(10).setPossiblePaths(pots.get(13));
		pots.get(10).setPossiblePaths(pots.get(16));
		pots.get(11).setPossiblePaths(pots.get(9));
		pots.get(11).setPossiblePaths(pots.get(10));
		pots.get(11).setPossiblePaths(pots.get(12));
		pots.get(12).setPossiblePaths(pots.get(11));
		pots.get(13).setPossiblePaths(pots.get(10));
		pots.get(13).setPossiblePaths(pots.get(15));
		pots.get(14).setPossiblePaths(pots.get(0));
		pots.get(14).setPossiblePaths(pots.get(8));
		pots.get(15).setPossiblePaths(pots.get(13));
		pots.get(15).setPossiblePaths(pots.get(16));
		pots.get(15).setPossiblePaths(pots.get(17));
		pots.get(15).setPossiblePaths(pots.get(19));
		pots.get(16).setPossiblePaths(pots.get(10));
		pots.get(16).setPossiblePaths(pots.get(15));
		pots.get(17).setPossiblePaths(pots.get(8));
		pots.get(17).setPossiblePaths(pots.get(15));
		pots.get(17).setPossiblePaths(pots.get(18));
		pots.get(18).setPossiblePaths(pots.get(17));
		pots.get(18).setPossiblePaths(pots.get(19));
		pots.get(19).setPossiblePaths(pots.get(15));
		pots.get(19).setPossiblePaths(pots.get(18));
	}
}
