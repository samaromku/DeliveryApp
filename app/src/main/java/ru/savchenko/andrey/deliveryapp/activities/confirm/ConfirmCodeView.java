package ru.savchenko.andrey.deliveryapp.activities.confirm;

public interface ConfirmCodeView {
    void showToast(String text);

    void setBtnParameters(boolean enabled, String text, String color);

    void tvTryCountSetText(String text);

    void finishAllActivities();
}
