package com.cg.paymentwallet.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.paymentwallet.dto.Customer;
import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;

public class PaymentWalletTestCases {
	private static IPaymentsWalletService paymentwalletservice = null;

	@BeforeClass
	public static void setUpBeforeClass() throws PaymentWalletException {
		paymentwalletservice = new PaymentWalletService();

	}

	@Test(expected = PaymentWalletException.class)
	public void withdrawFailWithPhone() throws PaymentWalletException {
		Customer customer = paymentwalletservice.withdrawMoney("9951610", new BigDecimal(2000));
		assertNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void withdrawPassWithMoney() throws PaymentWalletException {
		Customer customer = paymentwalletservice.withdrawMoney("995161070599", new BigDecimal(2000));
		assertNotNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void fundFailWithsourcePhone() throws PaymentWalletException {
		Customer customer = paymentwalletservice.fundTransfer("9951610", "8466919330", new BigDecimal(2000));
		assertNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void fundFailWithsourcePhoneMaxNumbers() throws PaymentWalletException {
		Customer customer = paymentwalletservice.fundTransfer("9951610705951", "8466919330", new BigDecimal(2000));
		assertNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void fundFailWithTargetPhoneMaxNumbers() throws PaymentWalletException {
		Customer customer = paymentwalletservice.fundTransfer("9951610705", "846691933045", new BigDecimal(2000));
		assertNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void fundFailWithTargetPhone() throws PaymentWalletException {
		Customer customer = paymentwalletservice.fundTransfer("9951610705", "846691", new BigDecimal(2000));
		assertNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void fundPassWithAllCorrect() throws PaymentWalletException {
		Customer customer = paymentwalletservice.fundTransfer("9951610705", "846691933045", new BigDecimal(2000));
		assertNotNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void showFailWithPhone() throws PaymentWalletException {
		Customer customer = paymentwalletservice.showBalance("995161");
		assertNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void showPassWithPhone() throws PaymentWalletException {
		Customer customer = paymentwalletservice.showBalance("9951610705");
		assertNotNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void printFailWithPhone() throws PaymentWalletException {
		Customer customer = paymentwalletservice.showBalance("995161");
		assertNull(customer);
	}

	@Test(expected = PaymentWalletException.class)
	public void printPassWithPhone() throws PaymentWalletException {
		Customer customer = paymentwalletservice.showBalance("9951610705");
		assertNotNull(customer);
	}
}
