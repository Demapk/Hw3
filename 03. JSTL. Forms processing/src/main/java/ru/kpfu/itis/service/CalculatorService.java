package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.model.Operation;
import ru.kpfu.itis.repository.OperationRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@SessionScope
public class CalculatorService {

    @Autowired
    private OperationRepository operationRepository;

    public void calculateResult(Calculator calculator) {
        double firstNumber = Double.parseDouble(calculator.getFirstNumber());
        double secondNumber = Double.parseDouble(calculator.getSecondNumber());
        double result = 0;
        switch (calculator.getOperation()) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "%":
                result = firstNumber % secondNumber;
                break;
        }
        calculator.setResult(result + "");
    }

    @Transactional
    public void saveWithHistory(Calculator calculator) {
        Operation operation = new Operation();
        operation.setCalculator(calculator);
        operation.setDate(new Date());
        operationRepository.save(operation);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Operation> findAllLaterThanAnHourAgo() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -1);
        Date before = cal.getTime();
        return operationRepository.findAllByDateBefore(before);
    }

}
