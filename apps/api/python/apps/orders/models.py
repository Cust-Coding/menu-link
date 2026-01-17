from django.db import models

class Orders(models.Model):
    STATUS_PENDING = "PENDING"
    STATUS_CANCELED = "CANCELED"
    STATUS_COMPLETED = "COMPLETED"
    STATUS_CHOICES = [
        (STATUS_PENDING, "Pending"),
        (STATUS_COMPLETED, "Completed"),
        (STATUS_CANCELED, "Canceled")
    ]
    
    status = models.CharField(max_length=10,
    choices=STATUS_CHOICES,
     default=STATUS_PENDING)

    ordered = models.DateField(auto_now_add=True)
