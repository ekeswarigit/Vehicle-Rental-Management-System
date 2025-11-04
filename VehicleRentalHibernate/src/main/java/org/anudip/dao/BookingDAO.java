package org.anudip.dao;

import org.anudip.model.Booking;
import org.anudip.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BookingDAO {

    public void addBooking(Booking booking) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(booking);
            tx.commit();
            System.out.println("✅ Booking confirmed!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Booking> getAllBookings() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Booking", Booking.class).list();
        }
    }

    public List<Booking> getBookingsByCustomer(int customerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM Booking WHERE customer.customer_id = :id", Booking.class)
                .setParameter("id", customerId)
                .list();
        }
    }
}
