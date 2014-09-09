package com.shih;

public class PrimeThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeThreads pt = new PrimeThreads(args);
		
	}

	public PrimeThreads(String[] arguments) {
		PrimeFinder[] finder = new PrimeFinder[arguments.length];
		for (int i = 0; i < arguments.length; i++) {
			try {
				long count = Long.parseLong(arguments[i]);
				finder[i] = new PrimeFinder(count);
				System.out.println("Looking for prime " + count);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boolean complete = false;
		while (!complete) {
			complete = true;
			for (int j = 0; j < finder.length; j++) {
				if (finder[j] == null)
					continue;
				if (!finder[j].finished) {
					complete = false;
				} else {
					displayResult(finder[j]);
					finder[j] = null;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void displayResult(PrimeFinder finder) {
		System.out.println("Prime " + finder.target + " is " + finder.prime);
	}

}
