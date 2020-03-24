package com.redsea.community.utils;

import java.util.*;

/**
 * @description: 判断工具类
 */
public class AssertUtil {

    /**
     * 功能描述:
     * 〈判断数组是否为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:43
     */
    public static <T> boolean isEmpty(T[] obj) {
        return null == obj || 0 == obj.length;
    }

    /**
     * 功能描述:
     * 〈判断数组是否不为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:43
     */
    public static <T> boolean isNotEmpty(T[] obj) {
        return !isEmpty(obj);
    }

    /**
     * 功能描述:
     * 〈判断对象是否为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:44
     */
    public static boolean isEmpty(Object obj) {
        return null == obj;
    }

    /**
     * 功能描述:
     * 〈判断对象是否不为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:45
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 功能描述:
     * 〈字符串是否为空〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/10/17 14:48
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    /**
     * 功能描述:
     * 〈字符串是否不为空〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/10/17 14:48
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 功能描述:
     * 〈判断集合是否为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:49
     */
    public static boolean isEmpty(Collection obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 功能描述:
     * 〈判断集合是否不为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:49
     */
    public static boolean isNotEmpty(Collection obj) {
        return !isEmpty(obj);
    }

    /**
     * 功能描述:
     * 〈判断map集合是否为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:50
     */
    public static boolean isEmpty(Map obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 功能描述:
     * 〈判断map集合是否不为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 14:50
     */
    public static boolean isNotEmpty(Map obj) {
        return !isEmpty(obj);
    }

    /**
     * 功能描述:
     * 〈char数值是否是数字〉
     *
     * @return : boolean
     * @params : [charValue]
     * @author : cwl
     * @date : 2019/10/17 14:55
     */
    public static boolean charIsNumb(int charValue) {
        return charValue >= 48 && charValue <= 57 || charValue >= 96 && charValue <= 105;
    }

    /**
     * 功能描述:
     * 〈判断字符串是否是纯数字浮点类型〉
     *
     * @return : boolean
     * @params : [s]
     * @author : cwl
     * @date : 2019/10/17 14:57
     */
    public static boolean isFloat(String s) {
        if (!(s.indexOf(".") > -1)) {
            return false;
        }
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (char aChar : chars) {
            if (aChar != 46) {
                if (!(aChar >= 48 && aChar <= 57 || aChar >= 96 && aChar <= 105)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 功能描述:
     * 〈非纯数字浮点类型〉
     *
     * @return : boolean
     * @params : [s]
     * @author : cwl
     * @date : 2019/10/17 15:15
     */
    public static boolean isNotFloat(String s) {
        return !isFloat(s);
    }

    /**
     * 功能描述:
     * 〈字符串是否是数字〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/10/17 15:08
     */
    public static boolean isNumb(String str) {
        if (isEmpty((Object) str)) {
            return false;
        } else {
            char[] chr = str.toCharArray();

            for (int i = 0; i < chr.length; ++i) {
                if (chr[i] < '0' || chr[i] > '9') {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * 功能描述:
     * 〈判断字符串是否不是数字〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/10/17 15:15
     */
    public static boolean isNotNumb(String str) {
        return !isNumb(str);
    }

    /**
     * 功能描述:
     * 〈判断字符串是否有长度,并自定义异常信息〉
     *
     * @return : void
     * @params : [str, msg]
     * @author : cwl
     * @date : 2019/10/17 15:09
     */
    public static void hasLength(String str, String msg) {
        if (str == null || str.length() < 1) {
            throw new RuntimeException(msg);
        }
    }

    /**
     * 功能描述:
     * 〈自定义参数校验异常〉
     *
     * @return : void
     * @params : [msg, obj]
     * @author : cwl
     * @date : 2019/10/17 15:24
     */
    public static void paramCheck(String msg, Object... obj) {
        for (Object o : obj) {
            // 参数异常
            if (isEmpty(o)) {
                throw new RuntimeException(msg);
            }
        }
    }

    /**
     * 功能描述:
     * 〈可变参数,判断是否所有对象都为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 15:10
     */
    public static boolean isAllEmpty(Object... obj) {
        Object[] var1 = obj;
        int var2 = obj.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Object o = var1[var3];
            if (!isEmpty(o)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 功能描述:
     * 〈可变参数-判断只要有任意一个对象为空,则为true〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 15:11
     */
    public static boolean isAnyEmpty(Object... obj) {
        Object[] var1 = obj;
        int var2 = obj.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Object o = var1[var3];
            if (isEmpty(o)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 功能描述:
     * 〈可变参数 -判断是否所有参数都不为空〉
     *
     * @return : boolean
     * @params : [obj]
     * @author : cwl
     * @date : 2019/10/17 15:11
     */
    public static boolean isAllNotEmpty(Object... obj) {
        Object[] var1 = obj;
        int var2 = obj.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Object o = var1[var3];
            if (isEmpty(o)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 功能描述:
     * 〈判断是否两个对象相等〉
     *
     * @return : boolean
     * @params : [o1, o2]
     * @author : cwl
     * @date : 2019/10/17 15:12
     */
    public static boolean isEqual(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        } else if (o2 == null) {
            return false;
        } else if (o1.getClass().isArray()) {
            for (int i = 0; i < ((Object[]) ((Object[]) o1)).length; ++i) {
                if (!isEqual(((Object[]) ((Object[]) o1))[i], ((Object[]) ((Object[]) o2))[i])) {
                    return false;
                }
            }

            return true;
        } else if (Collection.class.isAssignableFrom(o1.getClass())) {
            Iterator i1 = ((Collection) o1).iterator();
            Iterator i2 = ((Collection) o2).iterator();
            if (((Collection) o1).size() != ((Collection) o2).size()) {
                return false;
            } else {
                for (int i = 0; i < ((Collection) o1).size(); ++i) {
                    if (!isEqual(i1.next(), i2.next())) {
                        return false;
                    }
                }

                return true;
            }
        } else if (!Map.class.isAssignableFrom(o1.getClass())) {
            return o1.equals(o2);
        } else {
            Map<Object, Object> m1 = (Map) o1;
            Map<Object, Object> m2 = (Map) o2;
            if (m1.size() != m2.size()) {
                return false;
            } else if (!isEqual(m1.keySet(), m2.keySet())) {
                return false;
            } else {
                Iterator var4 = m1.entrySet().iterator();

                Map.Entry o;
                do {
                    if (!var4.hasNext()) {
                        return true;
                    }

                    o = (Map.Entry) var4.next();
                } while (m2.containsKey(o.getKey()) && isEqual(o.getValue(), m2.get(o.getKey())));

                return false;
            }
        }
    }

    /**
     * 功能描述:
     * 〈判断两个对象是否不相等〉
     *
     * @return : boolean
     * @params : [o1, o2]
     * @author : cwl
     * @date : 2019/10/17 15:13
     */
    public static boolean isNotEqual(Object o1, Object o2) {
        return !isEqual(o1, o2);
    }

    /**
     * 功能描述:
     * 〈比较两个集合是否相等〉
     *
     * @return : boolean
     * @params : [l1, l2]
     * @author : cwl
     * @date : 2019/10/17 14:46
     */
    public static boolean compare(List<Comparable> l1, List<Comparable> l2) {
        if (l1 != null && !l1.isEmpty()) {
            if (l2 != null && !l2.isEmpty()) {
                Collections.sort(l1);
                Collections.sort(l2);
                if (l1.size() != l2.size()) {
                    return false;
                } else {
                    for (int i = 0; i < l1.size(); ++i) {
                        if (((Comparable) l1.get(i)).compareTo(l2.get(i)) != 0) {
                            return false;
                        }
                    }

                    return true;
                }
            } else {
                return false;
            }
        } else {
            return l2 == null || l2.isEmpty();
        }
    }
}
