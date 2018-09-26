package java18.nio;


import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.InvalidMarkException;
import java.nio.ReadOnlyBufferException;

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
 *   <p> A buffer's <i>capacity</i> is the number of elements it contains.  The
 *   capacity of a buffer is never negative and never changes.  </p>
 *   缓冲区的容量是它包含的元素的数量。缓冲区的容量永远不会是负的，永远不会改变。
 *
 *   <p> A buffer's <i>limit</i> is the index of the first element that should
 *   not be read or written.  A buffer's limit is never negative and is never
 *   greater than its capacity.  </p>
 *   缓冲区的限制是第一个元素的索引，这个元素不应该被读或写。缓冲区的限制永远不会是负的，并且永远不会比缓冲区的容量大
 *
 *   <p> A buffer's <i>position</i> is the index of the next element to be
 *   read or written.  A buffer's position is never negative and is never
 *   greater than its limit.  </p>
 *   缓冲区的位置是下一个元素的索引，这个元素将要被读或者写入。缓冲区的位置永远不会是负的，并且永远不会比缓冲区的限制大
 *
 * </blockquote>
 *
 * <p> There is one subclass of this class for each non-boolean primitive type.
 *  对于每一个非布尔类型的原始类型，该类都有一个子类
 *
 * <h2> Transferring data </h2>
 *  传递数据
 *
 * <p> Each subclass of this class defines two categories of <i>get</i> and
 * <i>put</i> operations: </p>
 * 该类的每个子类定义了get和put操作的两种类别
 *
 * <blockquote>
 *
 *   <p> <i>Relative</i> operations read or write one or more elements starting
 *   at the current position and then increment the position by the number of
 *   elements transferred.  If the requested transfer exceeds the limit then a
 *   relative <i>get</i> operation throws a {@link BufferUnderflowException}
 *   and a relative <i>put</i> operation throws a {@link
 *   BufferOverflowException}; in either case, no data is transferred.  </p>
 *   相关操作从当前位置开始读取或写入一个或多个元素，然后将位置增加所传输的元素数量。
 *   如果请求的传输超出了限制，则相对get操作抛出{@link BufferUnderflowException}
 *   而相对put操作抛出{@link BufferOverflowException}；无论哪种情况，都不传输数据。
 *
 *   <p> <i>Absolute</i> operations take an explicit element index and do not
 *   affect the position.  Absolute <i>get</i> and <i>put</i> operations throw
 *   an {@link IndexOutOfBoundsException} if the index argument exceeds the
 *   limit.  </p>
 *   绝对操作采用显式元素索引，不影响位置。
 *   如果索引参数超过限制，则绝对get和PoT操作会引发{@link IndexOutOfBoundsException}
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
 *  标记复位（reset）
 *
 * <p> A buffer's <i>mark</i> is the index to which its position will be reset
 * when the {@link #reset reset} method is invoked.  The mark is not always
 * defined, but when it is defined it is never negative and is never greater
 * than the position.  If the mark is defined then it is discarded when the
 * position or the limit is adjusted to a value smaller than the mark.  If the
 * mark is not defined then invoking the {@link #reset reset} method causes an
 * {@link InvalidMarkException} to be thrown.
 *  缓冲区的标记是当调用reset方法时，它的索引位置将会被重置。
 *  这个标记通常不被定义，但是当它被定义的时候，它永远不会是一个负数，并且不会比缓冲区的位置大。
 *  如果这个标记被定义了，那么当位置和限制被调整后的值小于这个标记，那么标记会被丢弃。
 *  如果这个标记没有被定义，那么调用reset方法时，会引起一个{@link InvalidMarkException} 异常
 *
 *
 * <h2> Invariants </h2>
 * 不变式
 *
 * <p> The following invariant holds for the mark, position, limit, and
 * capacity values:
 *
 * <blockquote>
 *     <tt>0</tt> <tt>&lt;=</tt>
 *     <i>mark</i> <tt>&lt;=</tt>
 *     <i>position</i> <tt>&lt;=</tt>
 *     <i>limit</i> <tt>&lt;=</tt>
 *     <i>capacity</i>
 * </blockquote>
 *
 * 不变式 0<=mark<=position<=limit<=capacity
 *
 * <p> A newly-created buffer always has a position of zero and a mark that is
 * undefined.  The initial limit may be zero, or it may be some other value
 * that depends upon the type of the buffer and the manner in which it is
 * constructed.  Each element of a newly-allocated buffer is initialized
 * to zero.
 *  一个新创建的缓冲区 它有一个position是0的和一个未被定义的mark。
 *  初始limit可能是0，也可能是取决于缓冲区的类型和构造缓冲区的方式（构造方法）的其它值。
 *  新分配的缓冲区的每个元素的初始值都是0.
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
 *   <li><p> {@link #clear} makes a buffer ready for a new sequence of
 *   channel-read or relative <i>put</i> operations: It sets the limit to the
 *   capacity and the position to zero.  </p></li>
 *
 *   <li><p> {@link #flip} makes a buffer ready for a new sequence of
 *   channel-write or relative <i>get</i> operations: It sets the limit to the
 *   current position and then sets the position to zero.  </p></li>
 *
 *   <li><p> {@link #rewind} makes a buffer ready for re-reading the data that
 *   it already contains: It leaves the limit unchanged and sets the position
 *   to zero.  </p></li>
 *
 * </ul>
 *
 *
 * <h2> Read-only buffers </h2>
 *
 * <p> Every buffer is readable, but not every buffer is writable.  The
 * mutation methods of each buffer class are specified as <i>optional
 * operations</i> that will throw a {@link ReadOnlyBufferException} when
 * invoked upon a read-only buffer.  A read-only buffer does not allow its
 * content to be changed, but its mark, position, and limit values are mutable.
 * Whether or not a buffer is read-only may be determined by invoking its
 * {@link #isReadOnly isReadOnly} method.
 *
 *
 * <h2> Thread safety </h2>
 *
 * <p> Buffers are not safe for use by multiple concurrent threads.  If a
 * buffer is to be used by more than one thread then access to the buffer
 * should be controlled by appropriate synchronization.
 *
 *
 * <h2> Invocation chaining </h2>
 *
 * <p> Methods in this class that do not otherwise have a value to return are
 * specified to return the buffer upon which they are invoked.  This allows
 * method invocations to be chained; for example, the sequence of statements
 *
 * <blockquote><pre>
 * b.flip();
 * b.position(23);
 * b.limit(42);</pre></blockquote>
 *
 * can be replaced by the single, more compact statement
 *
 * <blockquote><pre>
 * b.flip().position(23).limit(42);</pre></blockquote>
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 */
public class BufferTest {
}
