module com.stream_pi.client {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.kordamp.iconli.core;
    requires org.kordamp.ikonli.javafx;
    requires AnimateFX;

    requires com.gluonhq.attach.lifecycle;
    requires com.gluonhq.attach.util;
    requires com.gluonhq.attach.storage;
    requires com.gluonhq.attach.browser;
    requires com.gluonhq.attach.vibration;
    requires com.gluonhq.attach.orientation;

    requires java.management;

    requires java.xml;

    opens com.stream_pi.client.window.settings.About to javafx.base;

    requires com.stream_pi.util;
    requires com.stream_pi.theme_api;
    requires com.stream_pi.action_api;

    requires org.kordamp.ikonli.fontawesome5;

    requires org.controlsfx.controls;

    exports com.stream_pi.client;
}