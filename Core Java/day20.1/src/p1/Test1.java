package p1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {

	public static void main(String[] args) {
		// Create a fixed size integer list n display it's elements
		List<Integer> list = Arrays.asList(10, 23, 1, 234, 56, 78);
		// imperative style
		for (int i : list)
			System.out.print(i + " ");
		// List IS A Iterable : YES : forEach
		// Iterable : public default forEach(Consumer<? super T> action))
		// In Consumer i/f : SAM : public void accept(T t)
		// arg : instance of the class that imple Consumer
		// 1. separate class imple Consumer : override accept
		// 2 . ano inner class : override accept
		System.out.println();
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.print(i + " ");// action
			}

		});
		// declarative : reduction of repeatative code (boilerplate code) : WHAT
		// lambda expr (args) -> {}
		list.forEach(i -> System.out.print(i + " "));
		//forEach : higher order function / method : passing pure func or behaviour

	}

}
