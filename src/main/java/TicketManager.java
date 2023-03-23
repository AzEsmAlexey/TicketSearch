import ru.netology.domain.Ticket;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public Ticket[] findAll(String airportFrom, String airportTo) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getSetOfTickets()) {
            if (matches(ticket, airportFrom, airportTo)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(Ticket ticket, String airportFrom, String airportTo) {
        if (ticket.getAirportFrom().equals(airportFrom)) {
            if (ticket.getAirportTo().equals(airportTo)) {
                return true;
            }
        }
        return false;
    }
}
