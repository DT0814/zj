package com.xawl.zj.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbSanswerPaperStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSanswerPaperStudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSapaidIsNull() {
            addCriterion("sapaid is null");
            return (Criteria) this;
        }

        public Criteria andSapaidIsNotNull() {
            addCriterion("sapaid is not null");
            return (Criteria) this;
        }

        public Criteria andSapaidEqualTo(Integer value) {
            addCriterion("sapaid =", value, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidNotEqualTo(Integer value) {
            addCriterion("sapaid <>", value, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidGreaterThan(Integer value) {
            addCriterion("sapaid >", value, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sapaid >=", value, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidLessThan(Integer value) {
            addCriterion("sapaid <", value, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidLessThanOrEqualTo(Integer value) {
            addCriterion("sapaid <=", value, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidIn(List<Integer> values) {
            addCriterion("sapaid in", values, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidNotIn(List<Integer> values) {
            addCriterion("sapaid not in", values, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidBetween(Integer value1, Integer value2) {
            addCriterion("sapaid between", value1, value2, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSapaidNotBetween(Integer value1, Integer value2) {
            addCriterion("sapaid not between", value1, value2, "sapaid");
            return (Criteria) this;
        }

        public Criteria andSaidIsNull() {
            addCriterion("said is null");
            return (Criteria) this;
        }

        public Criteria andSaidIsNotNull() {
            addCriterion("said is not null");
            return (Criteria) this;
        }

        public Criteria andSaidEqualTo(Integer value) {
            addCriterion("said =", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotEqualTo(Integer value) {
            addCriterion("said <>", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThan(Integer value) {
            addCriterion("said >", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("said >=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThan(Integer value) {
            addCriterion("said <", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThanOrEqualTo(Integer value) {
            addCriterion("said <=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidIn(List<Integer> values) {
            addCriterion("said in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotIn(List<Integer> values) {
            addCriterion("said not in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidBetween(Integer value1, Integer value2) {
            addCriterion("said between", value1, value2, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotBetween(Integer value1, Integer value2) {
            addCriterion("said not between", value1, value2, "said");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andPaidIsNull() {
            addCriterion("paid is null");
            return (Criteria) this;
        }

        public Criteria andPaidIsNotNull() {
            addCriterion("paid is not null");
            return (Criteria) this;
        }

        public Criteria andPaidEqualTo(Integer value) {
            addCriterion("paid =", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotEqualTo(Integer value) {
            addCriterion("paid <>", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThan(Integer value) {
            addCriterion("paid >", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paid >=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThan(Integer value) {
            addCriterion("paid <", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThanOrEqualTo(Integer value) {
            addCriterion("paid <=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidIn(List<Integer> values) {
            addCriterion("paid in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotIn(List<Integer> values) {
            addCriterion("paid not in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidBetween(Integer value1, Integer value2) {
            addCriterion("paid between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotBetween(Integer value1, Integer value2) {
            addCriterion("paid not between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andSnumIsNull() {
            addCriterion("snum is null");
            return (Criteria) this;
        }

        public Criteria andSnumIsNotNull() {
            addCriterion("snum is not null");
            return (Criteria) this;
        }

        public Criteria andSnumEqualTo(String value) {
            addCriterion("snum =", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotEqualTo(String value) {
            addCriterion("snum <>", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThan(String value) {
            addCriterion("snum >", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThanOrEqualTo(String value) {
            addCriterion("snum >=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThan(String value) {
            addCriterion("snum <", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThanOrEqualTo(String value) {
            addCriterion("snum <=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLike(String value) {
            addCriterion("snum like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotLike(String value) {
            addCriterion("snum not like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumIn(List<String> values) {
            addCriterion("snum in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotIn(List<String> values) {
            addCriterion("snum not in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumBetween(String value1, String value2) {
            addCriterion("snum between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotBetween(String value1, String value2) {
            addCriterion("snum not between", value1, value2, "snum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}