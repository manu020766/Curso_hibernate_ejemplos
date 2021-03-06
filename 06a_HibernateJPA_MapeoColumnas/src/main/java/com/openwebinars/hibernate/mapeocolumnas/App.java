package com.openwebinars.hibernate.mapeocolumnas;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entidades y mapeo de atributos
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MapeoColumnas");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();

		//Obtenemos el Calendar con el que gestionaremos las fechas
		Calendar calendar = Calendar.getInstance();

		// Construimos un objeto de tipo User
		User user1 = new User();
		user1.setName("Pepe");
		
		calendar.set(1982, 9, 18);
		user1.setBirthDate(calendar.getTime());

		// Construimos otro objeto de tipo User
		User user2 = new User();
		user2.setName("Juan");
		calendar.set(1990, 5, 20);
		user2.setBirthDate(calendar.getTime());
		
		//Persistimos los objetos
		em.persist(user1);
		em.persist(user2);

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();

	}
}
