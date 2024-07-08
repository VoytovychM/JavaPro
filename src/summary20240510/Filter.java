package summary20240510;

@FunctionalInterface
public interface Filter <T> {

    boolean apply(T t);

}
