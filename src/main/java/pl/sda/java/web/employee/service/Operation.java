package pl.sda.java.web.employee.service;

import org.hibernate.Session;

interface Operation<T> {
    T execute(Session session);
}