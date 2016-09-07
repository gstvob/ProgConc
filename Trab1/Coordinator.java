package pkg;

public class Coordinator {
	
	public Coordinator() {
	}
	public Pot ReleaseResource(Pot _request, Dog _requester) {
		while (_request.IsBeingUsed() == true) {
			_requester.Sleep(Main.timeUnit);
		}
		return _request;
	}
}
