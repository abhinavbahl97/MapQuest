package cmsc420.geometry;


public class Terminal extends City{

    public Terminal(int terminalX, int terminalY, int remoteX, int remoteY, String termianlName, String terminalCity, String terminalAirportName) {
            super(terminalAirportName, terminalCity, termianlName, terminalX, terminalY, remoteX, remoteY);
    }
    
    @Override
    public boolean isTerminal() {
        return true;
    }
}
