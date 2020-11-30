package com.market.apirest.tools;

import java.math.BigDecimal;
import java.util.List;

import com.market.apirest.models.Order;

public class OrderFix {

	public Order orderFix(Order order) {

		try {

			// for get itemAmount value catch all valors of products and multiply of units
			for (int i = 0; i < order.getItems().size(); i++) {

				order.getItems().get(i).setAmount(new BigDecimal(0));

				order.getItems().get(i).setAmount((order.getItems().get(i).getProduct().getUnitPrice()
						.multiply(order.getItems().get(i).getUnits())));

				System.out.println(order.getItems().get(i).getAmount());
			}

			// catch all valors of items amount and add to payment amount
			order.getPayment().setAmount(new BigDecimal(0));

			for (int i = 0; i < order.getItems().size(); i++) {
				order.getPayment().setAmount(order.getPayment().getAmount().add(order.getItems().get(i).getAmount()));
			}

			order.getPayment().setFirstInstallmentValue(new BigDecimal(0));
			order.getPayment().setOthersInstallmentValue(new BigDecimal(0));

			BigDecimal[] result = order.getPayment().getAmount()
					.divideAndRemainder(order.getPayment().getInstallments());

			order.getPayment().setFirstInstallmentValue(result[0].add(result[1]));
			order.getPayment().setOthersInstallmentValue(result[0]);

		} catch (Exception e) {
			System.out.println("error in fixOrder");
			e.getStackTrace();
		}

		return order;
	}

	public List<Order> orderFix(List<Order> list) {

		try {

			for (int i = 0; i < list.size(); i++) {
				Order order = list.get(i);

				// for get itemAmount value catch all valors of products and multiply of units
				for (int j = 0; j < order.getItems().size(); j++) {

					order.getItems().get(j).setAmount(new BigDecimal(0));
					order.getItems().get(j).setAmount((order.getItems().get(j).getProduct().getUnitPrice()
							.multiply(order.getItems().get(j).getUnits())));

				}

				// catch all valors of items amount and add to payment amount
				order.getPayment().setAmount(new BigDecimal(0));

				for (int k = 0; k < order.getItems().size(); k++) {
					order.getPayment()
							.setAmount((order.getPayment().getAmount().add(order.getItems().get(k).getAmount())));
				}

				order.getPayment().setFirstInstallmentValue(new BigDecimal(0));
				order.getPayment().setOthersInstallmentValue(new BigDecimal(0));

				BigDecimal[] result = order.getPayment().getAmount()
						.divideAndRemainder(order.getPayment().getInstallments());
				order.getPayment().setFirstInstallmentValue(result[0].add(result[1]));
				order.getPayment().setOthersInstallmentValue(result[0]);
				list.set(i, order);
			}

		} catch (Exception e) {
			System.out.println("error in fixOrder");
			e.getStackTrace();
		}
		return list;

	}

}
