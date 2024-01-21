package com.bridgelabz.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

//		<----------------USE CASE 2.1 ----------------->
		list.stream().forEach(n -> System.out.println(n));

//		<----------------USE CASE 2.2 ----------------->
		list.stream().map(Integer::doubleValue).forEach(n -> System.out.println(n));

//		<----------------USE CASE 2.3 ----------------->
		List<Double> doubleList = list.stream().map(Integer::doubleValue).collect(Collectors.toList());
		System.out.println(doubleList);
//		<----------------USE CASE 2.4 ----------------->
		List<Integer> evenList = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(evenList);
		
//		<----------------USE CASE 2.5 ----------------->
		Integer firstEven = evenList.stream().peek(evenNum -> System.out.println("First even number :- " + evenNum))
				.findFirst().orElse(null);
//		<----------------USE CASE 2.6 ----------------->
		evenList.stream().min((num1, num2) -> Integer.compare(num1, num2))
				                   .ifPresent(minEven -> System.out.println("minimum even number:-"+minEven));

        evenList.stream().max((num1, num2) -> Integer.compare(num1, num2))
                          .ifPresent(maxEven -> System.out.println("max even number:- "+maxEven));
//		<----------------USE CASE 2.7 ----------------->
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum of numbers :" + sum);
		OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
		System.out.println("Average of numbers :" + average);
//		<----------------USE CASE 2.8 ----------------->
		boolean matchAll = list.stream().allMatch(n -> n % 2 == 0);
		System.out.println("Match all even :- " + matchAll);
		boolean matchAny = list.stream().anyMatch(n -> n % 2 == 0);
		System.out.println("Match any even :- " + matchAny);
//		<----------------USE CASE 2.9 ----------------->
		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());

	}

}
