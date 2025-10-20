// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.appservice.examples.springbootmongodb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Objects;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String owner;
    private boolean finished;

    public TodoItem() {
    }

    public TodoItem(String description, String owner) {
        this.description = description;
        this.owner = owner;
        this.finished = false;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinish(boolean finished) {
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TodoItem)) {
            return false;
        }
        final TodoItem group = (TodoItem) o;
        return Objects.equals(this.getDescription(), group.getDescription())
                && Objects.equals(this.getOwner(), group.getOwner())
                && Objects.equals(this.getId(), group.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id, owner);
    }

    @Override
    public String toString() {
        if (id != null) {
            return id + ": " + description;
        } else {
            return description;
        }
    }
}

