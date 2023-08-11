package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entitites.CarRental;
import model.entitites.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: "); String carModel = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm): "); LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Devolução (dd/MM/yyyy hh:mm): "); LocalDateTime devolucao = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental car01 = new CarRental(retirada, devolucao,  new Vehicle(carModel));
		
		System.out.print("Entre com o preço por hora: "); double pricePerHour = sc.nextDouble();
		System.out.print("Enre com o preço por dia: "); double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(car01);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento Básico: " + car01.getInvoice().getBasicPayment());
		System.out.println("Imposto: " + car01.getInvoice().getTax());
		System.out.println("Pagamento total: " + car01.getInvoice().getTotalPayment());
		
		
		
		
		
		
		sc.close();

	}

}
