package java18.nio;


import org.junit.Test;

import java.nio.*;
import java.util.Spliterator;

/**
 * A container for data of a specific primitive type.
 * 一个用于存储特定的基础类型的数据的容器
 *
 * <p> A buffer is a linear, finite sequence of elements of a specific
 * primitive type.  Aside from its content, the essential properties of a
 * buffer are its capacity, limit, and position: </p>
 * 缓冲区是一种特定的原始类型的线性的、有限的元素序列。除了它的内容之外，缓冲区的基本属性是它的容量、限制和位置。
 *
 * <blockquote>
 *
 * <p> A buffer's <i>capacity</i> is the number of elements it contains.  The
 * capacity of a buffer is never negative and never changes.  </p>
 * 缓冲区的容量是它包含的元素的数量。缓冲区的容量永远不会是负的，永远不会改变。
 *
 * <p> A buffer's <i>limit</i> is the index of the first element that should
 * not be read or written.  A buffer's limit is never negative and is never
 * greater than its capacity.  </p>
 * 缓冲区的限制是第一个元素的索引，这个元素不应该被读或写。缓冲区的限制永远不会是负的，并且永远不会比缓冲区的容量大
 *
 * <p> A buffer's <i>position</i> is the index of the next element to be
 * read or written.  A buffer's position is never negative and is never
 * greater than its limit.  </p>
 * 缓冲区的位置是下一个元素的索引，这个元素将要被读或者写入。缓冲区的位置永远不会是负的，并且永远不会比缓冲区的限制大
 *
 * </blockquote>
 *
 * <p> There is one subclass of this class for each non-boolean primitive type.
 * 对于每一个非布尔类型的原始类型，该类都有一个子类
 *
 * <h2> Transferring data </h2>
 * 传递数据
 *
 * <p> Each subclass of this class defines two categories of <i>get</i> and
 * <i>put</i> operations: </p>
 * 该类的每个子类定义了get和put操作的两种类别
 *
 * <blockquote>
 *
 * <p> <i>Relative</i> operations read or write one or more elements starting
 * at the current position and then increment the position by the number of
 * elements transferred.  If the requested transfer exceeds the limit then a
 * relative <i>get</i> operation throws a {@link BufferUnderflowException}
 * and a relative <i>put</i> operation throws a {@link
 * BufferOverflowException}; in either case, no data is transferred.  </p>
 * 相关操作从当前位置开始读取或写入一个或多个元素，然后将位置增加所传输的元素数量。
 * 如果请求的传输超出了限制，则相对get操作抛出{@link BufferUnderflowException}
 * 而相对put操作抛出{@link BufferOverflowException}；无论哪种情况，都不传输数据。
 *
 * <p> <i>Absolute</i> operations take an explicit element index and do not
 * affect the position.  Absolute <i>get</i> and <i>put</i> operations throw
 * an {@link IndexOutOfBoundsException} if the index argument exceeds the
 * limit.  </p>
 * 绝对操作采用显式元素索引，不影响位置。
 * 如果索引参数超过限制，则绝对get和PoT操作会引发{@link IndexOutOfBoundsException}
 *
 * </blockquote>
 *
 * <p> Data may also, of course, be transferred in to or out of a buffer by the
 * I/O operations of an appropriate channel, which are always relative to the
 * current position.
 * 当然，数据也可以通过适当通道的I/O操作来传输到缓冲区或者从缓冲区中传送出去，这些I/O操作总是相对于当前位置的
 *
 *
 * <h2> Marking and resetting </h2>
 * 标记复位（reset）
 *
 * <p> A buffer's <i>mark</i> is the index to which its position will be reset
 * when the {@link #reset reset} method is invoked.  The mark is not always
 * defined, but when it is defined it is never negative and is never greater
 * than the position.  If the mark is defined then it is discarded when the
 * position or the limit is adjusted to a value smaller than the mark.  If the
 * mark is not defined then invoking the {@link #reset reset} method causes an
 * {@link InvalidMarkException} to be thrown.
 * 缓冲区的标记是当调用reset方法时，它的索引位置将会被重置。
 * 这个标记通常不被定义，但是当它被定义的时候，它永远不会是一个负数，并且不会比缓冲区的位置大。
 * 如果这个标记被定义了，那么当位置和限制被调整后的值小于这个标记，那么标记会被丢弃。
 * 如果这个标记没有被定义，那么调用reset方法时，会引起一个{@link InvalidMarkException} 异常
 *
 *
 * <h2> Invariants </h2>
 * 不变式
 *
 * <p> The following invariant holds for the mark, position, limit, and
 * capacity values:
 *
 * <blockquote>
 * <tt>0</tt> <tt>&lt;=</tt>
 * <i>mark</i> <tt>&lt;=</tt>
 * <i>position</i> <tt>&lt;=</tt>
 * <i>limit</i> <tt>&lt;=</tt>
 * <i>capacity</i>
 * </blockquote>
 * <p>
 * 不变式 0<=mark<=position<=limit<=capacity
 *
 * <p> A newly-created buffer always has a position of zero and a mark that is
 * undefined.  The initial limit may be zero, or it may be some other value
 * that depends upon the type of the buffer and the manner in which it is
 * constructed.  Each element of a newly-allocated buffer is initialized
 * to zero.
 * 一个新创建的缓冲区 它有一个position是0的和一个未被定义的mark。
 * 初始limit可能是0，也可能是取决于缓冲区的类型和构造缓冲区的方式（构造方法）的其它值。
 * 新分配的缓冲区的每个元素的初始值都是0.
 *
 * <h2> Clearing, flipping, and rewinding </h2>
 * 清除、翻转和倒回
 *
 * <p> In addition to methods for accessing the position, limit, and capacity
 * values and for marking and resetting, this class also defines the following
 * operations upon buffers:
 * 除了用于访问position，limit，capacity的值和标记和重置的方法之外，该类还在缓冲区上定义了以下操作：
 *
 * <ul>
 *
 * <li><p> {@link #clear} makes a buffer ready for a new sequence of
 * channel-read or relative <i>put</i> operations: It sets the limit to the
 * capacity and the position to zero.  </p></li>
 * {@link #clear}为了通道读取或相对于put操作的新序列而准备缓冲区：它会将limit=capacity 并且position =0
 *
 *
 * <li><p> {@link #flip} makes a buffer ready for a new sequence of
 * channel-write or relative <i>get</i> operations: It sets the limit to the
 * current position and then sets the position to zero.  </p></li>
 * {@link #flip}为了是通道写入或相对于get操作的新序列而准备缓冲区：它会将limit=position 并且 position=0
 *
 *
 * <li><p> {@link #rewind} makes a buffer ready for re-reading the data that
 * it already contains: It leaves the limit unchanged and sets the position
 * to zero.  </p></li>
 * {@link #rewind}使缓冲区准备好重新读取它已经包含的数据：它保持limit不变，并且position=0。
 *
 * </ul>
 *
 *
 * <h2> Read-only buffers </h2>
 * 只读缓冲区
 *
 * <p> Every buffer is readable, but not every buffer is writable.  The
 * mutation methods of each buffer class are specified as <i>optional
 * operations</i> that will throw a {@link ReadOnlyBufferException} when
 * invoked upon a read-only buffer.  A read-only buffer does not allow its
 * content to be changed, but its mark, position, and limit values are mutable.
 * Whether or not a buffer is read-only may be determined by invoking its
 * {@link #isReadOnly isReadOnly} method.
 * 每个缓冲区都是可读的，但是不是每个缓冲区都是可写入的。
 * 每个缓冲区类的变异方法被指定为可选操作，当在只读缓冲区上调用时，这些操作将抛出{@link ReadOnlyBufferException}。
 * 只读缓冲区不允许改变它的内容，但是它的mark,position,limit的值是可变的。
 * 缓冲区是否是只读，可以通过调用它的{@link #isReadOnly isReadOnly}方法。
 *
 *
 * <h2> Thread safety </h2>
 * 线程安全
 *
 * <p> Buffers are not safe for use by multiple concurrent threads.  If a
 * buffer is to be used by more than one thread then access to the buffer
 * should be controlled by appropriate synchronization.
 * 缓冲区对于多个并发线程使用是不安全的。
 * 如果要由多个线程使用缓冲区，则应通过适当的同步来控制对缓冲区的访问。
 *
 *
 * <h2> Invocation chaining </h2>
 * 链式调用
 *
 * <p> Methods in this class that do not otherwise have a value to return are
 * specified to return the buffer upon which they are invoked.  This allows
 * method invocations to be chained; for example, the sequence of statements
 *
 * <blockquote><pre>
 * b.flip();
 * b.position(23);
 * b.limit(42);</pre></blockquote>
 * <p>
 * can be replaced by the single, more compact statement
 *
 * <blockquote><pre>
 * b.flip().position(23).limit(42);</pre></blockquote>
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 */
public class BufferTest {

    /**
     * The characteristics of Spliterators that traverse and split elements
     * maintained in Buffers.
     */
    static final int SPLITERATOR_CHARACTERISTICS =
            Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.ORDERED;

    @Test
    public void test() {
        System.out.println(Spliterator.SIZED);
        System.out.println(Spliterator.SUBSIZED);
        System.out.println(Spliterator.ORDERED);
        System.out.println(SPLITERATOR_CHARACTERISTICS);
    }

    // Invariants: mark <= position <= limit <= capacity
    /*private int mark = -1;
    private int position = 0;
    private int limit;
    private int capacity;

    // Used only by direct buffers
    // NOTE: hoisted here for speed in JNI GetDirectBufferAddress
    long address;

    // Creates a new buffer with the given mark, position, limit, and capacity,
    // after checking invariants.
    //
    Buffer(int mark, int pos, int lim, int cap) {       // package-private
        if (cap < 0)
            throw new IllegalArgumentException("Negative capacity: " + cap);
        this.capacity = cap;
        limit(lim);
        position(pos);
        if (mark >= 0) {
            if (mark > pos)
                throw new IllegalArgumentException("mark > position: ("
                        + mark + " > " + pos + ")");
            this.mark = mark;
        }
    }

    *//**
     * Returns this buffer's capacity.
     *
     * @return The capacity of this buffer
     *//*
    public final int capacity() {
        return capacity;
    }

    *//**
     * Returns this buffer's position.
     *
     * @return The position of this buffer
     *//*
    public final int position() {
        return position;
    }

    *//**
     * Sets this buffer's position.  If the mark is defined and larger than the
     * new position then it is discarded.
     *
     * @param  newPosition
     *         The new position value; must be non-negative
     *         and no larger than the current limit
     *
     * @return This buffer
     *
     * @throws IllegalArgumentException
     *          If the preconditions on <tt>newPosition</tt> do not hold
     *//*
    public final Buffer position(int newPosition) {
        if ((newPosition > limit) || (newPosition < 0))
            throw new IllegalArgumentException();
        position = newPosition;
        if (mark > position) mark = -1;
        return this;
    }

    *//**
     * Returns this buffer's limit.
     *
     * @return The limit of this buffer
     *//*
    public final int limit() {
        return limit;
    }

    *//**
     * Sets this buffer's limit.  If the position is larger than the new limit
     * then it is set to the new limit.  If the mark is defined and larger than
     * the new limit then it is discarded.
     *
     * @param  newLimit
     *         The new limit value; must be non-negative
     *         and no larger than this buffer's capacity
     *
     * @return This buffer
     *
     * @throws IllegalArgumentException
     *          If the preconditions on <tt>newLimit</tt> do not hold
     *//*
    public final Buffer limit(int newLimit) {
        if ((newLimit > capacity) || (newLimit < 0))
            throw new IllegalArgumentException();
        limit = newLimit;
        if (position > limit) position = limit;
        if (mark > limit) mark = -1;
        return this;
    }

    *//**
     * Sets this buffer's mark at its position.
     *
     * @return This buffer
     *//*
    public final Buffer mark() {
        mark = position;
        return this;
    }

    *//**
     * Resets this buffer's position to the previously-marked position.
     *
     * <p> Invoking this method neither changes nor discards the mark's
     * value. </p>
     *
     * @return This buffer
     *
     * @throws InvalidMarkException
     *          If the mark has not been set
     *//*
    public final Buffer reset() {
        int m = mark;
        if (m < 0)
            throw new InvalidMarkException();
        position = m;
        return this;
    }

    *//**
     * Clears this buffer.  The position is set to zero, the limit is set to
     * the capacity, and the mark is discarded.
     *
     * <p> Invoke this method before using a sequence of channel-read or
     * <i>put</i> operations to fill this buffer.  For example:
     *
     * <blockquote><pre>
     * buf.clear();     // Prepare buffer for reading
     * in.read(buf);    // Read data</pre></blockquote>
     *
     * <p> This method does not actually erase the data in the buffer, but it
     * is named as if it did because it will most often be used in situations
     * in which that might as well be the case. </p>
     *
     * @return This buffer
     *//*
    public final Buffer clear() {
        position = 0;
        limit = capacity;
        mark = -1;
        return this;
    }

    *//**
     * Flips this buffer.  The limit is set to the current position and then
     * the position is set to zero.  If the mark is defined then it is
     * discarded.
     *
     * <p> After a sequence of channel-read or <i>put</i> operations, invoke
     * this method to prepare for a sequence of channel-write or relative
     * <i>get</i> operations.  For example:
     *
     * <blockquote><pre>
     * buf.put(magic);    // Prepend header
     * in.read(buf);      // Read data into rest of buffer
     * buf.flip();        // Flip buffer
     * out.write(buf);    // Write header + data to channel</pre></blockquote>
     *
     * <p> This method is often used in conjunction with the {@link
     * java.nio.ByteBuffer#compact compact} method when transferring data from
     * one place to another.  </p>
     *
     * @return This buffer
     *//*
    public final Buffer flip() {
        limit = position;
        position = 0;
        mark = -1;
        return this;
    }

    *//**
     * Rewinds this buffer.  The position is set to zero and the mark is
     * discarded.
     *
     * <p> Invoke this method before a sequence of channel-write or <i>get</i>
     * operations, assuming that the limit has already been set
     * appropriately.  For example:
     *
     * <blockquote><pre>
     * out.write(buf);    // Write remaining data
     * buf.rewind();      // Rewind buffer
     * buf.get(array);    // Copy data into array</pre></blockquote>
     *
     * @return This buffer
     *//*
    public final Buffer rewind() {
        position = 0;
        mark = -1;
        return this;
    }

    *//**
     * Returns the number of elements between the current position and the
     * limit.
     *
     * @return The number of elements remaining in this buffer
     *//*
    public final int remaining() {
        return limit - position;
    }

    *//**
     * Tells whether there are any elements between the current position and
     * the limit.
     *
     * @return  <tt>true</tt> if, and only if, there is at least one element
     *          remaining in this buffer
     *//*
    public final boolean hasRemaining() {
        return position < limit;
    }

    *//**
     * Tells whether or not this buffer is read-only.
     *
     * @return  <tt>true</tt> if, and only if, this buffer is read-only
     *//*
    public abstract boolean isReadOnly();

    *//**
     * Tells whether or not this buffer is backed by an accessible
     * array.
     *
     * <p> If this method returns <tt>true</tt> then the {@link #array() array}
     * and {@link #arrayOffset() arrayOffset} methods may safely be invoked.
     * </p>
     *
     * @return  <tt>true</tt> if, and only if, this buffer
     *          is backed by an array and is not read-only
     *
     * @since 1.6
     *//*
    public abstract boolean hasArray();

    *//**
     * Returns the array that backs this
     * buffer&nbsp;&nbsp;<i>(optional operation)</i>.
     *
     * <p> This method is intended to allow array-backed buffers to be
     * passed to native code more efficiently. Concrete subclasses
     * provide more strongly-typed return values for this method.
     *
     * <p> Modifications to this buffer's content will cause the returned
     * array's content to be modified, and vice versa.
     *
     * <p> Invoke the {@link #hasArray hasArray} method before invoking this
     * method in order to ensure that this buffer has an accessible backing
     * array.  </p>
     *
     * @return The array that backs this buffer
     *
     * @throws ReadOnlyBufferException
     *          If this buffer is backed by an array but is read-only
     *
     * @throws UnsupportedOperationException
     *          If this buffer is not backed by an accessible array
     *
     * @since 1.6
     *//*
    public abstract Object array();

    *//**
     * Returns the offset within this buffer's backing array of the first
     * element of the buffer&nbsp;&nbsp;<i>(optional operation)</i>.
     *
     * <p> If this buffer is backed by an array then buffer position <i>p</i>
     * corresponds to array index <i>p</i>&nbsp;+&nbsp;<tt>arrayOffset()</tt>.
     *
     * <p> Invoke the {@link #hasArray hasArray} method before invoking this
     * method in order to ensure that this buffer has an accessible backing
     * array.  </p>
     *
     * @return The offset within this buffer's array
     *          of the first element of the buffer
     *
     * @throws ReadOnlyBufferException
     *          If this buffer is backed by an array but is read-only
     *
     * @throws UnsupportedOperationException
     *          If this buffer is not backed by an accessible array
     *
     * @since 1.6
     *//*
    public abstract int arrayOffset();

    *//**
     * Tells whether or not this buffer is
     * <a href="ByteBuffer.html#direct"><i>direct</i></a>.
     *
     * @return  <tt>true</tt> if, and only if, this buffer is direct
     *
     * @since 1.6
     *//*
    public abstract boolean isDirect();


    // -- Package-private methods for bounds checking, etc. --

    *//**
     * Checks the current position against the limit, throwing a {@link
     * BufferUnderflowException} if it is not smaller than the limit, and then
     * increments the position.
     *
     * @return The current position value, before it is incremented
     *//*
    final int nextGetIndex() {                          // package-private
        if (position >= limit)
            throw new BufferUnderflowException();
        return position++;
    }

    final int nextGetIndex(int nb) {                    // package-private
        if (limit - position < nb)
            throw new BufferUnderflowException();
        int p = position;
        position += nb;
        return p;
    }

    *//**
     * Checks the current position against the limit, throwing a {@link
     * BufferOverflowException} if it is not smaller than the limit, and then
     * increments the position.
     *
     * @return The current position value, before it is incremented
     *//*
    final int nextPutIndex() {                          // package-private
        if (position >= limit)
            throw new BufferOverflowException();
        return position++;
    }

    final int nextPutIndex(int nb) {                    // package-private
        if (limit - position < nb)
            throw new BufferOverflowException();
        int p = position;
        position += nb;
        return p;
    }

    *//**
     * Checks the given index against the limit, throwing an {@link
     * IndexOutOfBoundsException} if it is not smaller than the limit
     * or is smaller than zero.
     *//*
    final int checkIndex(int i) {                       // package-private
        if ((i < 0) || (i >= limit))
            throw new IndexOutOfBoundsException();
        return i;
    }

    final int checkIndex(int i, int nb) {               // package-private
        if ((i < 0) || (nb > limit - i))
            throw new IndexOutOfBoundsException();
        return i;
    }

    final int markValue() {                             // package-private
        return mark;
    }

    final void truncate() {                             // package-private
        mark = -1;
        position = 0;
        limit = 0;
        capacity = 0;
    }

    final void discardMark() {                          // package-private
        mark = -1;
    }

    static void checkBounds(int off, int len, int size) { // package-private
        if ((off | len | (off + len) | (size - (off + len))) < 0)
            throw new IndexOutOfBoundsException();
    }*/

}
