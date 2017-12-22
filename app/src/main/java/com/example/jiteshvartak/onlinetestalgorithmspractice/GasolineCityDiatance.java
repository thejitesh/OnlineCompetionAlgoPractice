package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class GasolineCityDiatance {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int nCities = getNextInt(scanner);
		int nQueries = getNextInt(scanner);
		ArrayList<City> cities = new ArrayList<>();

		for (int i = 0; i < nCities; i++) {

			long distanceToNextCity = 0;
			try {
				distanceToNextCity = (i == nCities - 1) ? -1 : getNextLong(scanner);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				i--;
				continue;
			}
			City city = new City();
			city.cityID = i + 1;
			city.distanceToNextCity = distanceToNextCity;
			cities.add(city);
		}

		for (int i = 0; i < nCities; i++) {
			long gasolineFree =0 ;
			long gasolineCost = 0;
			try {
				gasolineFree = getNextLong(scanner);
				gasolineCost = getNextLong(scanner);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				i--;
				continue;
			}
			City city = cities.get(i);
			city.gasolineFree = gasolineFree;
			city.gasolineCost = gasolineCost;
		}

		for (int i = 0; i < nQueries; i++) {
			int startCityIndex = 0;
			int endCityIndex = 0;
			try {
				startCityIndex = getNextInt(scanner);
				endCityIndex = getNextInt(scanner);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				i--;
				continue;
			}
			long totalPurchase = 0;
			if (startCityIndex == endCityIndex) {
				totalPurchase = 0;
			} else {
				City startCity = cities.get(startCityIndex - 1);
				City endCity = cities.get(endCityIndex - 1);
				City cheapGasCity = startCity;
				long currentGasLevel = 0;
				for (int j = startCityIndex - 1; j < endCityIndex - 1; j++) {
					City currentCity = cities.get(j);
					City nextCity = cities.get(j + 1);
					currentGasLevel += currentCity.gasolineFree;
					long afterNextCityTravelGasRemaining = currentGasLevel - currentCity.distanceToNextCity;
					if (afterNextCityTravelGasRemaining < 0) {
						// purchase gas from cheap city
						totalPurchase += cheapGasCity.gasolineCost * (Math.abs(afterNextCityTravelGasRemaining));
						currentGasLevel += (Math.abs(afterNextCityTravelGasRemaining));
					}

					currentGasLevel -= currentCity.distanceToNextCity;
					if (currentCity.gasolineCost < cheapGasCity.gasolineCost) {
						cheapGasCity = currentCity;
					}
				}
			}
			System.out.println(totalPurchase+"");
		}

	}

	static long getNextLong(Scanner scanner) {
		return Long.parseLong(scanner.next().trim());
	}
	
	static int getNextInt(Scanner scanner) {
		return Integer.parseInt(scanner.next().trim());
	}

	static class City {

		int cityID;
		long distanceToNextCity;
		long gasolineFree;
		long gasolineCost;
	}

}
