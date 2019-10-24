package com.service;

import com.dao.*;
import com.enums.Pstatus;
import com.enums.RStatus;
import com.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private List<Place> placesIsReservation;
    private ReservationDao reservationDao;
    private PlaceDao placeDao;
    private KinoUserDao kinoUserDao;
    private DiscountDao discountDao;
    private BuyDao buyDao;
    private SessionDao sessionDao;
    private FilmDao filmDao;

    public ReservationServiceImpl(ReservationDao reservationDao, PlaceDao placeDao,
                                  KinoUserDao kinoUserDao, DiscountDao discountDao, BuyDao buyDao, SessionDao sessionDao, FilmDao filmDao) {
        this.reservationDao = reservationDao;
        this.placeDao = placeDao;
        this.kinoUserDao = kinoUserDao;
        this.discountDao = discountDao;
        this.buyDao = buyDao;
        this.sessionDao = sessionDao;
        this.filmDao = filmDao;
    }

    @Override
    public Long saveReservation(Reservation reservation) {
        return reservationDao.save(reservation).getId();

    }


    @Override
    public void deleteReservationById(Long idReser) {
        List<Place> placeList = placeDao.getFindbyIdReservaion(idReser);
        for (Place e: placeList
             ) {
            e.setReservation(null);
            e.setStatus(Pstatus.IsFree);
        }
        placeDao.saveAll(placeList);
        reservationDao.deleteById(idReser);
    }

    @Override
    public Long saveDiscount(Discount discount) {
        return discountDao.save(discount).getId();
    }

    @Override
    public void deleteDiscountById(Long id) {
        discountDao.deleteById(id);
    }

    @Override
    public Long updateReservation(Reservation reservation, Long id, int Status) {
        Reservation reservation1 = reservationDao.findById(id).get();
        reservation1.setBuy(reservation.getBuy());
        reservation1.setStart(LocalDateTime.now());
        reservation1.setEnd(reservation.getEnd());
        reservation1.setPlaces(reservation.getPlaces());
        if (Status == 0) {
            reservation1.setStatus(RStatus.IsAlive);
        } else if (Status == 1) {
            reservation1.setStatus(RStatus.IsNotAlive);
        } else if (Status == 2) {
            reservation1.setStatus(RStatus.isBuy);
        }
        return reservationDao.save(reservation1).getId();
    }

    @Override
    public Long saveAllReservation(ArrayList<Long> listIdPlace, Long idSess, KinoUser kinoUser) {
        KinoUser kinoUser1 = new KinoUser();
        Reservation reservation = new Reservation();
        if(kinoUser != null){
           kinoUser1 = kinoUserDao.findById(kinoUser.getId()).get();
            reservation.setKinoUser(kinoUser1);
        }


        reservation.setStart(LocalDateTime.now(ZoneId.of("UTC+4")));
        reservation.setEnd(sessionDao.getBeginSession(idSess).minusHours(1));

        reservation.setStatus(RStatus.IsAlive);
        BigDecimal resultPrice = new BigDecimal("0");
        reservation.setPrice(resultPrice);
        BigDecimal priceSession = sessionDao.findById(idSess).get().getPrice();
        Long id = reservationDao.save(reservation).getId();
        Reservation r = reservationDao.findById(id).get();
        ArrayList list = new ArrayList();
        for (int i = 0; i < listIdPlace.size(); i++) {
            list.add(listIdPlace.get(i));
            Place place = placeDao.findById(listIdPlace.get(i)).get();
            place.setStatus(Pstatus.IsReservation);
            place.setReservation(r);
            placeDao.save(place);
            resultPrice = resultPrice.add(priceSession);
        }
        List<Place> placeList =  new ArrayList<Place>();
        for (Long e: listIdPlace
        ) {
            placeList.add(placeDao.findById(e).get());
        }
        r.setPlaces(placeList);
        r.setPrice(resultPrice);
        return reservationDao.save(r).getId();
    }

    @Override
    public List<Place> getPlacesWithReservationId(Long id) {
        return placeDao.getFindbyIdReservaion(id);
    }

    @Override
    public List<Reservation> getFindByIdKinoUser(Long idKinU) {
        return reservationDao.getFindByIdKinoUser(idKinU);
    }

    @Override
    public Reservation getFindById(Long id) {
        Reservation reservation = reservationDao.findById(id).get();
        reservation.getPlaces().size();
        return reservation;
    }

    @Override
    public Long changeStatusReservation(Long id, Integer status) {
        Reservation reservation = reservationDao.findById(id).get();
        if (status == 0) {
            reservation.setStatus(RStatus.IsNotAlive);
        } else if (status == 1) {
            reservation.setStatus(RStatus.IsAlive);
        } else if (status == 2) {
            reservation.setStatus(RStatus.isBuy);
        }
        return reservationDao.save(reservation).getId();
    }

    @Override
    public List<Place> getPlacesForReservation(List<Place> places, Long idPlace) {
        places.add(placeDao.findById(idPlace).get());
        return places;
    }

    @Override
    public List<Place> deletePlaceFromList(List<Place> places, Long idPlace) {
        places.remove(placeDao.findById(idPlace).get());
        return places;
    }

    @Override
    public ArrayList getInfoFromReser(KinoUser kinoUser, Long enum_value) {
        List<Reservation> listReser = reservationDao.getFindByIdKinoUser(kinoUser.getId());
        ArrayList list = new ArrayList();
        for (Reservation e : listReser) {
            if (e.getStatus().ordinal() == enum_value) {
                ArrayList listEachReser = new ArrayList();
                ArrayList listAllPlace = new ArrayList();
                List<Place> listPlace = placeDao.getFindbyIdReservaion(e.getId());
                Hall hall = listPlace.get(0).getHall();
                Session session = sessionDao.findSessionByHall_Id(hall.getId());
                listEachReser.add(e.getPrice());
                listEachReser.add(listPlace.get(0).getHall().getNumber());
                listEachReser.add(session.getStart());
                listEachReser.add(session.getFilm().getName());
                for (Place ee : listPlace) {
                    ArrayList listInfo = new ArrayList();
                    listInfo.add(ee.getX());
                    listInfo.add(ee.getY());

                    listAllPlace.add(listInfo);
                }
                listEachReser.add(listAllPlace);
                listEachReser.add(e.getId());
                list.add(listEachReser);
            }
        }

        return list;
    }
}
