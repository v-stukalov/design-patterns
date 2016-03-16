import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FunctionalStyle {
    public interface Function<F, T> {
        T apply(F from);
    }

    public static final Function<Integer, String> INT_TO_STRING = new Function<Integer, String>() {
        @Override
        public String apply(Integer from) {
            return from.toString();
        }
    };

    public static <F, T> List<T> map(Collection<F> from, Function<? super F, ? extends T> transformer) {
        List<T> result = new ArrayList<>();
        for (F f : from) result.add(transformer.apply(f));
        return result;
    }

    public static <E> String join(Collection<E> elements, String delim) {
        StringBuilder sb = new StringBuilder();
        for (E e : elements)
            sb.append(e).append(delim);
        return sb.delete(sb.lastIndexOf(delim), sb.length()).toString();
    }

    public String joinNumbers(Collection<? extends Integer> numbers) {
        return join(map(numbers, INT_TO_STRING), ", ");
    }

    public static void main(String... args) {
        System.out.println(INT_TO_STRING.apply(9000));
        System.out.println(new FunctionalStyle().joinNumbers(Arrays.asList(new Integer[]{23, 42, 14, 98})));
    }
}
