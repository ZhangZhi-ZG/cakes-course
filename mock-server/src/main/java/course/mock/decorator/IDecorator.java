package course.mock.decorator;

public interface IDecorator<T> {

    T decorate(T data);
}
