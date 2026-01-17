from django.db import models


class Menus(models.Model):
    productName = models.CharField(max_length=255)
    productPrice = models.DecimalField()

