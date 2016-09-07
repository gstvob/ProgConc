package pkg;

public class Coordinator {
	
	public Coordinator() {
	}
	//Método que apenas pega o pote que o cachorro quer entrar e verifica se ele pode entrar
	//Se o pote estiver em uso o cachorro vai dormir por 100 milisegundos senão ele entra no pote.
	public Pot ReleaseResource(Pot _request, Dog _requester) {
		while (_request.IsBeingUsed() == true) {
			_requester.Sleep(Main.timeUnit);
		}
		return _request;
	}
}
