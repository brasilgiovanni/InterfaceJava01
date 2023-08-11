package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entitites.CarRental;
import model.entitites.Vehicle;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: "); String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm): "); LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Devolução (dd/MM/yyyy hh:mm): "); LocalDateTime devolucao = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental car01 = new CarRental(retirada, devolucao,  new Vehicle(carModel));
		
		
		
		
		
		
		
		sc.close();

	}

}
