import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketTests {

    Ticket ticket1 = new Ticket(001, 170, "ARS", "ATA", 720);
    Ticket ticket2 = new Ticket(002, 220, "ARS", "ATA", 720);
    Ticket ticket3 = new Ticket(003, 150, "AUF", "AUG", 720);
    Ticket ticket4 = new Ticket(004, 170, "ARS", "ATA", 720);
    Ticket ticket5 = new Ticket(005, 440, "ARS", "AUG", 720);
    Ticket ticket6 = new Ticket(006, 325, "ARS", "ATA", 720);
    Ticket ticket7 = new Ticket(007, 112, "ARS", "ATA", 720);

    @Test
    public void testAddMethod() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getSetOfTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddMethodEmpty() {
        TicketRepository repo = new TicketRepository();

        Ticket[] expected = {};
        Ticket[] actual = repo.getSetOfTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveByIdMethod() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.removeById(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.getSetOfTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveByIdMethodEmpty() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.removeById(ticket1.getId());

        Ticket[] expected = {};
        Ticket[] actual = repo.getSetOfTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testFindAllAnfSortSeveralTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("ARS", "ATA");
        Ticket[] expected = {ticket7, ticket1, ticket4, ticket2, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testFindAllAnfSortOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("ARS", "AUG");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testFindAllAnfSortZeroTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("AUS", "AUG");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
