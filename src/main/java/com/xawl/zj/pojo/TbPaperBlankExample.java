package com.xawl.zj.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbPaperBlankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPaperBlankExample() {
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

        public Criteria andPabidIsNull() {
            addCriterion("pabid is null");
            return (Criteria) this;
        }

        public Criteria andPabidIsNotNull() {
            addCriterion("pabid is not null");
            return (Criteria) this;
        }

        public Criteria andPabidEqualTo(Integer value) {
            addCriterion("pabid =", value, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidNotEqualTo(Integer value) {
            addCriterion("pabid <>", value, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidGreaterThan(Integer value) {
            addCriterion("pabid >", value, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pabid >=", value, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidLessThan(Integer value) {
            addCriterion("pabid <", value, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidLessThanOrEqualTo(Integer value) {
            addCriterion("pabid <=", value, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidIn(List<Integer> values) {
            addCriterion("pabid in", values, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidNotIn(List<Integer> values) {
            addCriterion("pabid not in", values, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidBetween(Integer value1, Integer value2) {
            addCriterion("pabid between", value1, value2, "pabid");
            return (Criteria) this;
        }

        public Criteria andPabidNotBetween(Integer value1, Integer value2) {
            addCriterion("pabid not between", value1, value2, "pabid");
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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