/*
 *长度验证
 * */
const validatLength = (rule, value, callback) => {
  value += ''
  if (value === '' || value === 'undefined' || value === null || undefined === value) {
    callback()
  }
  if (rule.maxlength < value.length) {
    callback(new Error(rule.msg))
  } else {
    callback()
  }
}
/**
 * 电话验证
 * */
const validatPhone = (rule, value, callback) => {
  if (value === '' || value === 'undefined' || value === null || undefined === value) {
    callback()
  }
  const patt1 = /^1(3|4|5|6|7|8|9)\d{9}$/
  const patt2 = /^0\d{2}\d{7,8}$/
  const patt3 = /^0\d{2}-\d{7,8}$/
  if (patt1.test(value) || patt2.test(value) || patt3.test(value)) {
    callback()
  } else {
    callback(new Error(rule.msg))
  }
}
/**
 *身份证验证
 * */
const validatCard = (rule, value, callback) => {
  if (value === '' || value === 'undefined' || value === null || undefined === value) {
    callback()
  }
  const patt1 = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
  if (!patt1.test(value)) {
    callback(new Error(rule.msg))
  } else {
    callback()
  }
}
/**
 *邮编验证
 * */
const validatPostcode = (rule, value, callback) => {
  if (value === '' || value === 'undefined' || value === null || undefined === value) {
    callback()
  }
  const patt1 = /^[0-9]{6}$/
  if (!patt1.test(value)) {
    callback(new Error(rule.msg))
  } else {
    callback()
  }
}
/**
 * 数字验证
 * */
const validatNum = (rule, value, callback) => {
  if (value === '' || value === 'undefined' || value === null || undefined === value) {
    callback()
  }
  const patt1 = /^(\\-|\\+)?\\d+(\\.\\d+)?$/
  if (!patt1.test(value) && isNaN(value)) {
    callback(new Error(rule.msg))
  } else {
    callback()
  }
}
/**
 * 邮箱验证
 * */
const validatEmail = (rule, value, callback) => {
  if (value === '' || value === 'undefined' || value === null || undefined === value) {
    callback()
  }
  const patt1 = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
  if (!patt1.test(value)) {
    callback(new Error(rule.msg))
  } else {
    callback()
  }
}

export {
  validatLength,
  validatPhone,
  validatCard,
  validatPostcode,
  validatNum,
  validatEmail
}
