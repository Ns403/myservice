package com.myservice.utils;

import com.myservice.exception.DaoException;
import com.myservice.exception.ResourceNotFoundException;
import com.myservice.exception.ServiceException;
import org.slf4j.helpers.FormattingTuple;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName: AssertUtils
 * @Description: *
 *               <p>
 *               断言 使用异常流程控制,异常控制流程比if else '状态码'控制可读性更强
 *               </p>
 *               <b style="color:red"> 注 :
 *               异常的处理效率比条件分支低,内部系统可用异常形式控制流程,对外http/api接口则使用'错误码'. </b>
 * @author 再来一个芒果
 * @date 2018年3月19日 下午12:23:43
 * 
 */
public abstract class AssertUtils {

	public static final Object[] EMPTY_OBJ_ARRAY = new Object[] {};

	private static String formatMessage(String format, Object... params) {
		FormattingTuple arrayFormat = MessageFormatter.arrayFormat(format, params);
		return arrayFormat.getMessage();
	}

	/**
	 * 断言对象是否为NULL
	 * 
	 * @param obj
	 * @param message
	 */
	public static void assertNull(Object obj, String message) {
		assertNull(obj, message, EMPTY_OBJ_ARRAY);
	}

	/**
	 * 断言对象是否为NULL
	 * 
	 * @param obj
	 * @param format
	 *            格式化数据("Hi {}. My name is {}.", "Alice", "Bob") => Hi Alice. My name is Bob.
	 * @param params
	 */
	public static void assertNull(Object obj, String format, Object... params) {
		if (obj == null) {
			throwServiceException(format, params);
		}
	}

	/**
	 * 断言对象是否为空
	 * 
	 * @param obj
	 *            类型可以为{String,Array,Collection,Map}
	 * @param message
	 */
	public static void assertEmpty(Object obj, String message) {
		assertEmpty(obj, message, EMPTY_OBJ_ARRAY);
	}

	/**
	 * 断言对象是否为空
	 * 
	 * @param obj
	 *            类型可以为{String,Array,Collection,Map}
	 * @param format
	 * @param params
	 */
	public static void assertEmpty(Object obj, String format, Object... params) {
		if (obj == null) {
			throwServiceException(format, params);
		}

		if (obj instanceof String && StringUtils.isEmpty( obj)) {
			throwServiceException(format, params);
		}

		if (obj.getClass().isArray() && ((Object[]) obj).length == 0) {
			throwServiceException(format, params);
		}

		if (obj instanceof Collection && ((Collection<?>) obj).isEmpty()) {
			throwServiceException(format, params);
		}

		if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty()) {
			throwServiceException(format, params);
		}
	}
	
	/**
	 * service 层断言
	 *
	 * @param condition
	 *            : 断言条件
	 * @param message
	 *            : 错误信息
	 * @throws ServiceException
	 */
	public static void assertTrue(boolean condition, String message) {
		if (condition) {
			assertTrue(condition, message, EMPTY_OBJ_ARRAY);
		}
	}
	
	/**
	 * service 层断言
	 *
	 * @param condition
	 *            : 断言条件
	 * @param format
	 *            : 错误信息
	 * @throws ServiceException
	 */
	public static void assertTrue(boolean condition, String format, Object ...params) {
		if (condition) {
			throwServiceException(format, params);
		}
	}

	/**
	 * 如果条件为<code>true</code> throw {@link ResourceNotFoundException}
	 *
	 * @param condition
	 *            : 断言条件
	 * @param message
	 *            : 错误信息
	 * @throws ResourceNotFoundException
	 */
	public static void assertResourceNotFoundIsTrue(boolean condition, String message) {
		if (condition) {
			throw new ResourceNotFoundException(message);
		}

	}




	/**
	 * service 层断言
	 *
	 * @param condition
	 *            : 断言条件
	 * @param message
	 *            : 错误信息
	 * @throws ServiceException
	 */
	public static void isTrue(boolean condition, String message) {
		if(condition) {
			throwServiceException(message, EMPTY_OBJ_ARRAY);
		}
	}
	
	/**
	 * service 层断言
	 *
	 * @param condition
	 *            : 断言条件
	 * @param format
	 *            : 错误信息
	 * @throws ServiceException
	 */
	public static void isTrue(boolean condition, String format, Object ...params) {
		if(condition) {
			throwServiceException(format, params);
		}
	}

	/**
	 * dao 层断言
	 *
	 * @param condition
	 *            : 断言条件
	 * @param message
	 *            : 错误信息
	 * @throws DaoException
	 */
	public static void assertDaoIsTrue(boolean condition, String message) {
		daoServiceException(condition, message);
	}

	/**
	 * 断言
	 *
	 * @param condition
	 *            : 断言条件
	 * @param message
	 *            : 错误信息
	 * @throws DaoException
	 *             如果条件为<code>true</code> ,则会抛Service异常(异常为运行时异常,在Spring中会有统一异常处理)
	 */
	private static void assertServiceException(boolean condition, String message) {
		if (condition) {
			throw new ServiceException(message);
		}
	}

	/**
	 * 断言
	 *
	 * @param condition
	 *            : 断言条件
	 * @param message
	 *            : 错误信息
	 * @throws DaoException
	 *             如果条件为<code>true</code>,则会抛Dao异常(异常为运行时异常,在Spring中会有统一异常处理)
	 */
	private static void daoServiceException(boolean condition, String message) {
		if (condition) {
			throw new DaoException(message);
		}
	}


	public static void throwServiceException(String format, Object... params) {
		throw new ServiceException(formatMessage(format, params));
	}

}
